package net.darmo_creations.ti83_compiler.compilers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import net.darmo_creations.ti83_compiler.exceptions.FileFormatException;
import net.darmo_creations.ti83_compiler.exceptions.UnknownTokenException;

public class Decompiler {
  /**
   * Decompiles the given file with a default indentation of 4.
   * 
   * @param path the path to the file
   * @param language the target language
   * @throws FileFormatException
   */
  public void decompile(String path, String language) throws FileFormatException, UnknownTokenException, IOException {
    decompile(path, language, BinaryFileParser.DEFAULT_INDENT_SIZE);
  }

  /**
   * Decompiles the given file.
   * 
   * @param path the path to the file
   * @param language the target language
   * @param indentSize indentation size
   * @throws FileFormatException
   */
  public void decompile(String path, String language, int indentSize) throws FileFormatException, UnknownTokenException, IOException {
    File f;
    String progName;
    String[] lines;

    if (!language.equals("en") && !language.equals("fr")) {
      throw new IllegalArgumentException("Unknown language " + language);
    }

    f = new File(path);

    if (!f.getName().substring(f.getName().indexOf('.') + 1).toUpperCase().matches("8XP"))
      throw new FileFormatException("Unsupported file format.");
    if (!f.exists())
      throw new IOException("File does not exist!");

    try {
      lines = new BinaryFileParser(language, indentSize).parse(Files.readAllBytes(Paths.get(f.getAbsolutePath())));
    }
    catch (IOException ex) {
      throw new IOException("Could not open file.", ex);
    }
    progName = lines[0];

    File source = new File(f.getParent() + File.separator + progName + ".ti83" + language);

    try (PrintWriter pw = new PrintWriter(source.getAbsolutePath(), "UTF-8")) {
      for (int i = 0; i < lines.length; i++) {
        if (i == 0) {
          continue;
        }
        pw.println(lines[i]);
      }
    }
    catch (IOException ex) {
      throw new IOException("Could not write file " + ex.getMessage(), ex);
    }

    System.out.println("Decompiling successful.");
    System.out.println("File saved at " + source.getAbsolutePath());
  }
}
