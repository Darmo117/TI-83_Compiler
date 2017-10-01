package net.darmo_creations.ti83_compiler.compilers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.darmo_creations.ti83_compiler.BinaryFile;
import net.darmo_creations.ti83_compiler.exceptions.FileFormatException;
import net.darmo_creations.ti83_compiler.exceptions.UnknownTokenException;
import net.darmo_creations.ti83_compiler.utils.ArraysUtil;

/**
 * This class parses a .8xp file into a source code text file.
 *
 * @author Damien Vergnet
 */
class BinaryFileParser {
  private static final int INDENT_SIZE = 4;

  private final byte[] header;

  public BinaryFileParser() {
    this.header = new byte[11];
    ArraysUtil.stringCopy(BinaryFile.HEADER, this.header, 0, 11);
  }

  /**
   * Parses a .8xp file then returns the corresponding source code. The first line is the program's
   * name.
   * 
   * @param content the content to parse
   * @param lang the language of the instructions to return
   * @return the program's source code
   * @throws UnknownTokenException if the parser stumbles upon an unknown token
   * @throws FileFormatException if the file is corrupted
   */
  public String[] parse(byte[] content, String lang) throws UnknownTokenException, FileFormatException {
    List<String> lines = new ArrayList<>();

    try {
      // Checks the header.
      if (!checkHeader(content)) {
        throw new FileFormatException("Invalid header.");
      }

      int length = toInt(content[0x48], content[0x49]);

      // Checks the length.
      if (toInt(content[0x35], content[0x36]) - 19 != length //
          || toInt(content[0x39], content[0x3A]) - 2 != length //
          || toInt(content[0x46], content[0x47]) - 2 != length) {
        throw new FileFormatException("Invalid length.");
      }

      // Gets the name.
      lines.add(getName(content));

      // Checksum.
      if (!checkSum(content)) {
        System.err.println("WARNING: invalid checksum, the file may be corrupted.");
        System.err.println("We will still attempt to open it.");
        System.err.println();
      }

      String currentLine = "";
      String indent = "";
      boolean increaseIndent = false;
      boolean inIfWithoutThen = false;
      boolean newLineAfterIf = false;

      for (int i = 0x4A; i < 0x4A + length; i++) {
        boolean found = false;

        if (content[i] == 0x3F) {
          lines.add(indent + currentLine);

          if (increaseIndent) {
            indent = addIndent(indent);
            increaseIndent = false;
          }
          if (newLineAfterIf) {
            indent = removeIndent(indent);
            newLineAfterIf = false;
          }
          if (inIfWithoutThen) {
            indent = addIndent(indent);
            inIfWithoutThen = false;
            newLineAfterIf = true;
          }
          currentLine = "";
          found = true;
          continue;
        }

        for (Token token : Tokens.TOKENS) {
          byte[] bytes = token.getBytes();
          int tokenLength = bytes.length;
          boolean tokenMatches = Arrays.equals(bytes, Arrays.copyOfRange(content, i, i + tokenLength));

          if (tokenMatches && (token.getLanguage() == null || token.getLanguage().equals(lang))) {
            // Repeat, While or For detected, indent the next lines.
            if (token.getInstruction().equals("While ") //
                || token.getInstruction().equals("Repeat ") //
                || token.getInstruction().equals("For(")) {
              increaseIndent = true;
            }
            // If detected.
            else if (token.getInstruction().equals("If ")) {
              inIfWithoutThen = true;
            }
            // Then detected. If it is in the same line as an If, increase indent;
            // else, decrease current indent then re-increase indent.
            else if (token.getInstruction().equals("Then")) {
              if (newLineAfterIf) {
                indent = removeIndent(indent);
                newLineAfterIf = false;
              }
              inIfWithoutThen = false;
              increaseIndent = true;
            }
            // Else detected. Decrease current indent then increase indent.
            else if (token.getInstruction().equals("Else")) {
              indent = removeIndent(indent);
              increaseIndent = true;
            }
            // End detected. Decrease current indent.
            else if (token.getInstruction().equals("End")) {
              indent = removeIndent(indent);
            }
            // If the instruction after an if is on the same line.
            // E.g.: 'If B:Disp B'
            else if (inIfWithoutThen && token.getInstruction().equals(":")) {
              inIfWithoutThen = false;
            }

            currentLine += token.getInstruction();
            found = true;
            i += tokenLength - 1;
            break;
          }
        }

        if (i == 0x4A + length - 1) {
          lines.add(currentLine);
        }

        // There is one unknown token, abort.
        if (!found) {
          throw new UnknownTokenException(content[i]);
        }
      }

      return lines.toArray(new String[lines.size()]);
    }
    catch (Exception ex) {
      throw new FileFormatException("Corrupted file.", ex);
    }
  }

  /**
   * Checks the header's validity.
   */
  private boolean checkHeader(final byte[] bytes) {
    byte[] header = new byte[11];

    System.arraycopy(bytes, 0, header, 0, 11);

    return Arrays.equals(header, this.header);
  }

  /**
   * Returns the program's name.
   */
  private String getName(byte[] bytes) {
    String name = "";

    for (int i = 0x3C; i < 0x3C + 8 && bytes[i] != 0; i++) {
      name += (bytes[i] == 0x5B) ? 'θ' : (char) bytes[i];
    }

    return name;
  }

  /**
   * Performs the checksum.
   */
  private boolean checkSum(byte[] bytes) {
    int sum = 0;

    for (int i = 0x37; i < bytes.length - 2; i++) {
      sum += (bytes[i] < 0) ? bytes[i] + 256 : bytes[i];
    }

    return (sum & 0xFFFF) == toInt(bytes[bytes.length - 2], bytes[bytes.length - 1]);
  }

  /**
   * Converts two bytes to an int.
   */
  private int toInt(byte lsb, byte msb) {
    int msb_i = (msb < 0) ? msb + 256 : msb;
    int lsb_i = (lsb < 0) ? lsb + 256 : lsb;

    return (msb_i << 8) | lsb_i;
  }

  /**
   * Adds an indent level.
   */
  private String addIndent(String indent) {
    return String.format("%" + INDENT_SIZE + "s", "") + indent;
  }

  /**
   * Removes an indent level.
   */
  private String removeIndent(String indent) {
    if (indent.length() < 4)
      return "";
    return indent.substring(0, indent.length() - 4);
  }
}
