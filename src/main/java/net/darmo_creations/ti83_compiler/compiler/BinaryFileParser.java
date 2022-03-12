package net.darmo_creations.ti83_compiler.compiler;

import net.darmo_creations.ti83_compiler.BinaryFile;
import net.darmo_creations.ti83_compiler.exceptions.FileFormatException;
import net.darmo_creations.ti83_compiler.exceptions.UnknownTokenException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class parses an array of bytes, extracted from a .8xp file, into a source code text file.
 *
 * @author Damien Vergnet
 */
class BinaryFileParser {
  private final Language language;
  private final int indentSize;

  /**
   * Create a parser.
   *
   * @param language   Language for the decompiled source code.
   * @param indentSize Indent size for the decompiled source code.
   */
  public BinaryFileParser(final Language language, final int indentSize) {
    this.language = language;
    this.indentSize = indentSize;
  }

  /**
   * Parse an array of bytes then return the corresponding source code.
   * The first line is the program’s name.
   *
   * @param bytes The bytes to parse.
   * @return The program’s source code as a list of lines.
   * @throws FileFormatException If the file is corrupted.
   */
  public Result parse(final byte[] bytes) throws FileFormatException {
    try {
      if (!this.isHeaderValid(bytes)) {
        throw new FileFormatException("Invalid header.");
      }
      if (!this.isCheckSumValid(bytes)) {
        System.err.println("WARNING: invalid checksum, the file may be corrupted.");
        System.err.println("We will still attempt to open and parse it.");
      }
      int length = this.toInt(bytes[0x48], bytes[0x49]);
      if (this.toInt(bytes[0x35], bytes[0x36]) - 19 != length //
          || this.toInt(bytes[0x39], bytes[0x3A]) - 2 != length //
          || this.toInt(bytes[0x46], bytes[0x47]) - 2 != length) {
        throw new FileFormatException("Invalid file length.");
      }

      List<String> lines = this.decompileLines(bytes, length);
      return new Result(this.getProgramName(bytes), lines);
    } catch (Exception ex) {
      throw new FileFormatException("Corrupted file: " + ex.getMessage(), ex);
    }
  }

  private List<String> decompileLines(final byte[] bytes, final int length) throws UnknownTokenException {
    String currentLine = "";
    String indent = "";
    boolean increaseIndent = false;
    boolean inIfWithoutThen = false;
    boolean newLineAfterIf = false;

    List<String> lines = new ArrayList<>();
    for (int i = 0x4A; i < 0x4A + length; i++) {
      boolean found = false;

      if (bytes[i] == Tokens.LINE_END.getBytes()[0]) {
        lines.add(indent + currentLine);

        if (increaseIndent) {
          indent = this.addIndent(indent);
          increaseIndent = false;
        }
        if (newLineAfterIf) {
          indent = this.removeIndent(indent);
          newLineAfterIf = false;
        }
        if (inIfWithoutThen) {
          indent = this.addIndent(indent);
          inIfWithoutThen = false;
          newLineAfterIf = true;
        }
        currentLine = "";
        continue;
      }

      for (Token token : Tokens.TOKENS) {
        byte[] tokenBytes = token.getBytes();
        int tokenBytesLength = tokenBytes.length;
        boolean tokenMatches = Arrays.equals(tokenBytes, Arrays.copyOfRange(bytes, i, i + tokenBytesLength));

        if (tokenMatches) {
          if (token.getInstruction(this.language).equals("While ")
              || token.getInstruction(this.language).equals("Repeat ")
              || token.getInstruction(this.language).equals("For(")) {
            increaseIndent = true;

          } else if (token.getInstruction(this.language).equals("If ")) {
            inIfWithoutThen = true;

          } else if (token.getInstruction(this.language).equals("Then")) {
            if (newLineAfterIf) {
              indent = this.removeIndent(indent);
              newLineAfterIf = false;
            }
            inIfWithoutThen = false;
            increaseIndent = true;

          } else if (token.getInstruction(this.language).equals("Else")) {
            indent = this.removeIndent(indent);
            increaseIndent = true;

          } else if (token.getInstruction(this.language).equals("End")) {
            indent = this.removeIndent(indent);

          }
          // If the instruction after an if is on the same line.
          // E.g.: 'If B:Disp B'
          else if (inIfWithoutThen && token.getInstruction(this.language).equals(":")) {
            inIfWithoutThen = false;
          }

          currentLine += token.getInstruction(this.language);
          found = true;
          i += tokenBytesLength - 1;
          break;
        }
      }

      if (i == 0x4A + length - 1) {
        lines.add(currentLine);
      }

      if (!found) {
        throw new UnknownTokenException(bytes[i]);
      }
    }
    return lines;
  }

  /**
   * Return whether the header is valid.
   */
  private boolean isHeaderValid(final byte[] bytes) {
    byte[] expectedBytes = BinaryFile.HEADER.getBytes(StandardCharsets.UTF_8);
    byte[] actualBytes = new byte[expectedBytes.length];
    System.arraycopy(bytes, 0, actualBytes, 0, expectedBytes.length);
    return Arrays.equals(actualBytes, expectedBytes);
  }

  /**
   * Return the program’s name.
   */
  private String getProgramName(final byte[] bytes) {
    StringBuilder name = new StringBuilder();

    for (int i = 0x3C; i < 0x3C + 8 && bytes[i] != 0; i++) {
      name.append((bytes[i] == 0x5B) ? 'θ' : (char) bytes[i]);
    }

    return name.toString();
  }

  /**
   * Perform the checksum.
   */
  private boolean isCheckSumValid(final byte[] bytes) {
    int sum = 0;

    for (int i = 0x37; i < bytes.length - 2; i++) {
      sum += (bytes[i] < 0) ? bytes[i] + 256 : bytes[i];
    }

    return (sum & 0xFFFF) == this.toInt(bytes[bytes.length - 2], bytes[bytes.length - 1]);
  }

  /**
   * Convert two bytes into an int.
   *
   * @param lsb Lowest significative byte.
   * @param msb Most significative byte.
   */
  private int toInt(final byte lsb, final byte msb) {
    int msb_i = (msb < 0) ? msb + 256 : msb;
    int lsb_i = (lsb < 0) ? lsb + 256 : lsb;

    return (msb_i << 8) | lsb_i;
  }

  /**
   * Add an indent level.
   */
  private String addIndent(final String indent) {
    return String.format("%" + this.indentSize + "s", "") + indent;
  }

  /**
   * Remove an indent level.
   */
  private String removeIndent(final String indent) {
    if (indent.length() < this.indentSize) {
      return "";
    }
    return indent.substring(0, indent.length() - this.indentSize);
  }

  public static class Result {
    public final String programName;
    public final List<String> lines;

    public Result(String programName, List<String> lines) {
      this.programName = programName;
      this.lines = lines;
    }
  }
}
