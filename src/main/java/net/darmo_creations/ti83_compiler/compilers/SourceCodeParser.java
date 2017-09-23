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
    List<Token> tokens = new ArrayList<>();
    List<Byte> bytes = new ArrayList<>();

    trim(srcCode);
    // Used to show the parse errors.
    final String[] errorSource = new String[srcCode.length];

    System.arraycopy(srcCode, 0, errorSource, 0, srcCode.length);

    replaceTags(srcCode);

    for (int i = 0; i < srcCode.length; i++) {
      String line = srcCode[i];

      line = line.replaceAll("\\^\\(_?-1\\)", "⁻¹");
      line = line.replaceAll("\\^\\(2\\)", "²");
      line = line.replaceAll("\\^\\(3\\)", "³");
      line = line.replaceAll("(?:list|liste)([A-Zθ]{1,8})", "ʟ$1");

      // Used to show the parse errors.
      final String errorLine = errorSource[i];
      int index = 0;

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
            tokens.add(token);

            found = true;
            index += instr.length();
            break;
          }
        }

        // There is one unknown instruction, abort.
        if (!found) {
          throw new UnknownInstructionException(errorLine, i + 1, index + 1);
        }
      }

      tokens.add(Tokens.LINE_END);
    }

    if (optimise) {
      boolean inString = false;
      Token closedParenthesis = Tokens.getToken(")").get();
      Token closedCBrackets = Tokens.getToken("}").get();
      Token quote = Tokens.getToken("\"").get();
      Token arrow = Tokens.getToken("->").get();
      Token columns = Tokens.getToken(":").get();
      Token star = Tokens.getToken("*").get();

      boolean changed;
      do {
        changed = false;

        for (int i = 0; i < tokens.size(); i++) {
          Token previous = i > 0 ? tokens.get(i - 1) : null;
          Token token = tokens.get(i);
          Token next = i < tokens.size() - 1 ? tokens.get(i + 1) : null;
          // #f:0
          boolean ignoreToken = (token.equals(quote) || !inString &&  (token.equals(closedParenthesis) || token.equals(closedCBrackets)))
              && next != null && (next.equals(arrow) || next.equals(Tokens.LINE_END))
              || !inString && token.equals(closedParenthesis) && next != null && next.equals(columns)
              || !inString && token.equals(star) && (previous != null && !Tokens.isDigit(previous) || next != null && !Tokens.isDigit(next));
          // #f:1

          if (ignoreToken) {
            changed = true;
            tokens.remove(i);
            i--;
          }

          if (token.equals(quote))
            inString = !inString;
          if (token.equals(Tokens.LINE_END) || token.equals(arrow))
            inString = false;
        }
      } while (changed);
    }

    for (Token token : tokens) {
      for (byte b : token.getBytes()) {
        bytes.add(b);
      }
    }

    byte[] data = new byte[bytes.size()];

    for (int i = 0; i < bytes.size(); i++) {
      data[i] = bytes.get(i);
    }

    return data;
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
