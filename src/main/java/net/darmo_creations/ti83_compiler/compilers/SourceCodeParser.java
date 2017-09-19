package net.darmo_creations.ti83_compiler.compilers;

import java.util.ArrayList;
import java.util.List;

import net.darmo_creations.ti83_compiler.exceptions.UnknownInstructionException;

public class SourceCodeParser {
  public static byte[] parse(String[] srcCode) throws UnknownInstructionException {
    List<Byte> bytes = new ArrayList<Byte>();
    byte[] data;

    trim(srcCode);
    // Used to show the parse errors.
    final String[] ERR_SRC = new String[srcCode.length];

    System.arraycopy(srcCode, 0, ERR_SRC, 0, srcCode.length);

    replaceTags(srcCode);

    int ind;
    for (int i = 0; i < srcCode.length; i++) {
      String line = srcCode[i];
      // Used to show the parse errors.
      final String ERR_LINE = ERR_SRC[i];
      ind = 0;

      while (line.length() > 0) {
        boolean changed = false;

        for (Token token : Tokens.TOKENS) {
          String instr = token.getInstruction();

          if (line.charAt(0) == '#') {
            line = "";
            changed = true;
            break;
          }

          if (instr.length() > line.length()) {
            continue;
          }

          if (line.substring(0, instr.length()).equals(instr)) {
            // Add the token to the array.
            for (byte b : token.getToken()) {
              bytes.add(b);
            }
            // Remove the current instruction.
            line = line.substring(instr.length());
            changed = true;
            ind += instr.length();
            break;
          }
        }

        // There is one unknown instruction, abort.
        if (!changed) {
          throw new UnknownInstructionException(ERR_LINE, i + 1, ind + 1);
        }
      }

      // New line token.
      bytes.add((byte) 0x3F);
    }

    data = new byte[bytes.size()];

    for (int i = 0; i < bytes.size(); i++) {
      data[i] = bytes.get(i);
    }

    return data;
  }

  private static void trim(String[] srcCode) {
    for (int i = 0; i < srcCode.length; i++) {
      srcCode[i] = srcCode[i].replaceFirst("^\\s+", "");
    }
  }

  private static void replaceTags(String[] srcCode) {
    for (int i = 0; i < srcCode.length; i++) {
      for (String regex : Tokens.TAGS_REGEXES.keySet()) {
        srcCode[i] = srcCode[i].replaceAll("&(" + regex + ");", Tokens.TAGS_REGEXES.get(regex));
      }
    }

  }

  private SourceCodeParser() {}
}
