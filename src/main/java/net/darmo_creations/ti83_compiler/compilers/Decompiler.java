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
   * Decompiles the given file.
   * 
   * @param path the path to the file
   * @param lang the target language
   * @throws FileFormatException
   * @throws UnknownTokenException
   * @throws IOException
   */
  public void decompile(String path, String lang) throws FileFormatException, UnknownTokenException, IOException {
    File f;
    String progName;
    String[] lines;

    if (!lang.equals("en") && !lang.equals("fr")) {
      throw new IllegalArgumentException("Unknown language " + lang);
    }

    f = new File(path);

    if (!f.getName().substring(f.getName().indexOf('.') + 1).toUpperCase().matches("8XP")) {
      throw new FileFormatException("Unsupported file format.");
    }

    try {
      lines = new BinaryFileParser().parse(Files.readAllBytes(Paths.get(f.getAbsolutePath())), lang);
    }
    catch (IOException ex) {
      throw new IOException("Could not open file.", ex);
    }
    progName = lines[0];

    File source = new File(f.getParent() + File.separator + progName + ".ti83" + lang);

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
