package net.darmo_creations.ti83_compiler.compilers;

import java.io.File;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.List;

import net.darmo_creations.ti83_compiler.BinaryFile;
import net.darmo_creations.ti83_compiler.exceptions.FileFormatException;
import net.darmo_creations.ti83_compiler.exceptions.UnknownInstructionException;

public class Compiler {
  /**
   * Compiles the given file.
   * 
   * @param path the path to the file
   * @param optimise if true, the compiled program will be optimised
   * @throws IOException
   * @throws FileFormatException
   */
  public void compile(String path, boolean optimise, boolean editable) throws IOException, FileFormatException {
    File f;
    String progName;
    String[] srcCode;

    f = new File(path);

    if (!f.getName().substring(f.getName().indexOf('.') + 1).toUpperCase().matches("TI83(EN|FR)?"))
      throw new FileFormatException("Unsupported file format.");
    if (!f.exists())
      throw new IOException("File does not exist!");

    progName = f.getName().substring(0, f.getName().indexOf(".")).toUpperCase();
    srcCode = getSourceCode(f);

    byte[] data;

    try {
      data = new SourceCodeParser().parse(srcCode, optimise);
    }
    catch (UnknownInstructionException ex) {
      String offset = "\n";

      for (int i = 0; i < ex.getColumnOffset() - 1; i++) {
        offset += " ";
      }

      throw new RuntimeException("Unknown token at line " + ex.getErrorOffset() + ":\n" + ex.getMessage() + offset + "^", ex);
    }

    BinaryFile bf = new BinaryFile(f.getParent(), progName, data, editable);

    try {
      bf.writeFile();
    }
    catch (IOException ex) {
      throw new IOException("Could not write file " + ex.getMessage(), ex);
    }

    System.out.println("Building successful.");
    System.out.println("File saved at " + bf.getAbsolutePath());
  }

  /**
   * Returns the content of the given file.
   */
  private String[] getSourceCode(File file) throws IOException {
    try {
      List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));

      return lines.toArray(new String[lines.size()]);
    }
    catch (NullPointerException | InvalidPathException | SecurityException ex) {
      throw new IOException("Could not open file.", ex);
    }
    catch (MalformedInputException ex) {
      throw new IOException("Unsupported encoding! Source files must be encoded in UTF-8.");
    }
  }
}
