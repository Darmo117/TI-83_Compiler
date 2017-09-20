package net.darmo_creations.ti83_compiler.compilers;

import java.util.ArrayList;
import java.util.List;

import net.darmo_creations.ti83_compiler.exceptions.UnknownInstructionException;

class SourceCodeParser {
  /**
   * Parses the given source code then returns the corresponding tokens.
   * 
   * @param srcCode the source code
   * @param optimise if true, the compiled program will be optimised
   * @return the tokens
   * @throws UnknownInstructionException
   */
  public byte[] parse(String[] srcCode, boolean optimise) throws UnknownInstructionException {
    List<Byte> bytes = new ArrayList<Byte>();
    byte[] data;

    trim(srcCode);
    // Used to show the parse errors.
    final String[] errorSource = new String[srcCode.length];

    System.arraycopy(srcCode, 0, errorSource, 0, srcCode.length);

    replaceTags(srcCode);

    int index;
    for (int i = 0; i < srcCode.length; i++) {
      String line = srcCode[i];
      // Used for optimisation
      String lastToken = "";
      boolean inString = false;
      // Used to show the parse errors.
      final String errorLine = errorSource[i];
      index = 0;

      while (index < line.length()) {
        boolean found = false;

        for (Token token : Tokens.TOKENS) {
          String instr = token.getInstruction();

          if (line.charAt(index) == '#') {
            line = "";
            found = true;
            break;
          }

          if (instr.length() > line.substring(index).length()) {
            continue;
          }

          if (line.substring(index, index + instr.length()).equals(instr)) {
            String next = getNextToken(line, index + instr.length());
            boolean ignoreInstr = optimise && ((instr.equals(")") || instr.equals("\"")) && (next.equals("->") || next.equals("\n"))
                || !inString && instr.equals(")") && next.equals(":")
                || !inString && instr.equals("*") && (!Tokens.isDigit(lastToken) || !Tokens.isDigit(next)));

            if (!ignoreInstr) {
              for (byte b : token.getBytes()) {
                bytes.add(b);
              }
            }

            if (instr.equals("\""))
              inString = !inString;
            found = true;
            lastToken = instr;
            index += instr.length();
            break;
          }
        }

        // There is one unknown instruction, abort.
        if (!found) {
          throw new UnknownInstructionException(errorLine, i + 1, index + 1);
        }
      }

      // New line token.
      bytes.add((byte) 0x3F);
      inString = false;
    }

    data = new byte[bytes.size()];

    for (int i = 0; i < bytes.size(); i++) {
      data[i] = bytes.get(i);
    }

    return data;
  }

  private String getNextToken(String line, int index) {
    if (index >= line.length() - 1)
      return "\n";
    for (Token token : Tokens.TOKENS) {
      String instr = token.getInstruction();
      if (line.substring(index).length() >= instr.length() && line.substring(index, index + instr.length()).equals(instr))
        return instr;
    }
    return "";
  }

  /**
   * Trims the whitespace at the left of the line.
   */
  private void trim(String[] srcCode) {
    for (int i = 0; i < srcCode.length; i++) {
      srcCode[i] = srcCode[i].replaceFirst("^\\s+", "");
    }
  }

  /**
   * Replaces all entity tags (&##;) by the corresponding characters.
   */
  private void replaceTags(String[] srcCode) {
    for (int i = 0; i < srcCode.length; i++) {
      for (String regex : Tokens.TAGS_REGEXES.keySet()) {
        srcCode[i] = srcCode[i].replaceAll("&(" + regex + ");", Tokens.TAGS_REGEXES.get(regex));
      }
    }
  }
}
