package net.darmo_creations.ti83_compiler.compiler;

import net.darmo_creations.ti83_compiler.BinaryFile;
import net.darmo_creations.ti83_compiler.exceptions.FileFormatException;
import net.darmo_creations.ti83_compiler.exceptions.UnknownInstructionException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * This class defines methods to compile source files into .8xp binary files and vice-versa.
 */
public final class Compiler {
  public static final String VERSION = "1.3";
  public static final String BASE_SOURCE_EXTENSION = "ti83";
  public static final int DEFAULT_INDENT_SIZE = 2;

  /**
   * Compile the given .ti83* file.
   *
   * @param path     The path to the file.
   * @param optimise Whether the compiled program should be optimized.
   * @throws IOException         If the file does not exist or the file is not in UTF-8.
   * @throws FileFormatException If the file is in unknown format.
   */
  public static void compile(final String path, final boolean optimise, final boolean editable) throws IOException, FileFormatException {
    File f = new File(path).getAbsoluteFile();
    if (!f.exists()) {
      throw new IOException("File does not exist!");
    }

    int dotIndex = f.getName().indexOf('.');
    String progName = f.getName().substring(0, dotIndex);
    String ext = f.getName().substring(dotIndex + 1).toLowerCase();
    Pattern extPattern = Pattern.compile(String.format("%s(%s)",
        BASE_SOURCE_EXTENSION,
        Arrays.stream(Language.values()).map(Language::getCode).collect(Collectors.joining("|"))
    ));
    Matcher m = extPattern.matcher(ext);
    if (!m.find()) {
      throw new FileFormatException("Unsupported file format.");
    }

    byte[] data;
    try {
      data = new SourceCodeParser(Language.fromCode(m.group(1))).parse(getSourceCode(f), optimise);
    } catch (UnknownInstructionException ex) {
      StringBuilder offset = new StringBuilder("\n");
      for (int i = 0; i < ex.getColumnOffset() - 1; i++) {
        offset.append(' ');
      }
      throw new RuntimeException("Unknown token at line " + ex.getErrorOffset() + ":\n" + ex.getMessage() + offset + "^", ex);
    }

    BinaryFile bf = new BinaryFile(f.getParent(), progName, data, editable);
    try {
      bf.writeFile();
    } catch (IOException ex) {
      throw new IOException("Could not write file " + ex.getMessage(), ex);
    }

    System.out.println("Build successful.");
    System.out.println("File saved at " + bf.getFullPath());
  }

  /**
   * Decompile the given .8xp file.
   *
   * @param path         The path to the file.
   * @param languageCode The language for the decompiled source code.
   * @param indentSize   Indent size.
   * @throws FileFormatException If the file to decompile has an invalid extension.
   */
  public static void decompile(final String path, final String languageCode, final int indentSize)
      throws FileFormatException, IOException {
    Language lang = Language.fromCode(languageCode);
    if (lang == null) {
      throw new IllegalArgumentException("Unknown language code: " + languageCode);
    }

    File f = new File(path).getAbsoluteFile();
    if (!f.getName().substring(f.getName().indexOf('.') + 1).toUpperCase().matches(BinaryFile.EXTENSION.toUpperCase())) {
      throw new FileFormatException("Unsupported file format!");
    }
    if (!f.exists()) {
      throw new IOException("File does not exist!");
    }

    BinaryFileParser.Result result = new BinaryFileParser(lang, indentSize).parse(Files.readAllBytes(Paths.get(f.getAbsolutePath())));
    File output = new File(f.getParent() + File.separator + result.programName + "." + BASE_SOURCE_EXTENSION + languageCode);
    try (PrintWriter pw = new PrintWriter(output.getAbsolutePath(), StandardCharsets.UTF_8.name())) {
      result.lines.forEach(pw::println);
    }

    System.out.println("Decompiling successful.");
    System.out.println("File saved at " + output.getAbsolutePath());
  }

  /**
   * Return the content of the given source file.
   */
  private static String[] getSourceCode(final File file) throws IOException {
    try {
      List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
      return lines.toArray(new String[0]);
    } catch (NullPointerException | InvalidPathException | SecurityException ex) {
      throw new IOException("Could not open file.", ex);
    } catch (MalformedInputException ex) {
      throw new IOException("Unsupported encoding! Source files must be encoded in UTF-8.");
    }
  }

  private Compiler() {
  }
}
