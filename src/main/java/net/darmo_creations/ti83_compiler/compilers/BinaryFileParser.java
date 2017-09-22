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
    List<String> lines = new ArrayList<String>();
    StringBuffer curLine = new StringBuffer();
    String indentManager = "";
    // If true, the indentation will be reported to the next line.
    boolean indentNextLine = false;
    // True when an If instruction without Then has been encountered.
    boolean if_ = false;
    // True when there is a new line after an If instruction.
    boolean newLine = false;
    // If true, the indentation will be removed for the next line.
    boolean removeIndent = false;

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

      for (int i = 0x4A; i < 0x4A + length; i++) {
        boolean changed = false;

        if (content[i] == 0x3F) {
          lines.add(indentManager + curLine.toString());
          if (removeIndent) {
            indentManager = removeIndent(indentManager);
            removeIndent = false;
            newLine = false;
          }
          if (indentNextLine && !if_) {
            indentManager = addIndent(indentManager);
            indentNextLine = false;
          }
          if (if_) {
            indentManager = addIndent(indentManager);
            if_ = false;
            removeIndent = true;
            newLine = true;
          }
          curLine.delete(0, curLine.length());
          changed = true;
          continue;
        }

        for (Token token : Tokens.TOKENS) {
          byte[] bytes = token.getBytes();
          boolean matches = true;
          int j;

          for (j = 0; j < bytes.length; j++) {
            if (bytes[j] != content[i + j]) {
              matches = false;
              break;
            }
          }

          if (matches && (token.getLanguage() == null || token.getLanguage().equals(lang))) {
            // Repeat, While or For detected, indent the next line.
            if (Arrays.equals(Tokens.getToken("Repeat "), token.getBytes()) //
                || Arrays.equals(Tokens.getToken("While "), token.getBytes()) //
                || Arrays.equals(Tokens.getToken("For("), token.getBytes())) {
              indentNextLine = true;
            }
            // If detected.
            if (Arrays.equals(Tokens.getToken("If "), token.getBytes())) {
              if_ = true;
            }
            // Then detected. If it is in the same line as an If, indent the next line;
            // else, remove current indent then indent next line.
            if (Arrays.equals(Tokens.getToken("Then"), token.getBytes())) {
              if (newLine) {
                indentManager = removeIndent(indentManager);
                newLine = false;
              }
              if_ = false;
              indentNextLine = true;
            }
            // Else detected. Remove current indent then indent next line.
            if (Arrays.equals(Tokens.getToken("Else"), token.getBytes())) {
              indentManager = removeIndent(indentManager);
              indentNextLine = true;
            }
            // End detected. Remove current indent.
            if (Arrays.equals(Tokens.getToken("End"), token.getBytes())) {
              indentManager = removeIndent(indentManager);
              indentNextLine = false;
            }

            curLine.append(token.getInstruction());
            changed = true;
            i += j - 1;
            break;
          }
        }

        if (i == 0x4A + length - 1) {
          lines.add(curLine.toString());
        }

        // There is one unknown token, abort.
        if (!changed) {
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
    // TODO check
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
