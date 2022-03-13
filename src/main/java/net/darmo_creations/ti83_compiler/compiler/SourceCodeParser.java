package net.darmo_creations.ti83_compiler.compiler;

import net.darmo_creations.ti83_compiler.exceptions.UnknownInstructionException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class is used to parse source code.
 */
class SourceCodeParser {
  private final Language language;

  /**
   * Create a parser.
   *
   * @param language Language to use for parsing.
   */
  public SourceCodeParser(final Language language) {
    this.language = language;
  }

  /**
   * Parse the given source code then returns the corresponding tokens.
   *
   * @param srcCode  The source code.
   * @param optimise Whether to optimize the compiled program.
   * @return The sequence of tokens.
   * @throws UnknownInstructionException If an unknown sequence of characters is encountered.
   */
  public byte[] parse(String[] srcCode, final boolean optimise) throws UnknownInstructionException {
    this.trim(srcCode);
    this.replaceAliases(srcCode);

    List<Token> tokens = this.extractTokens(srcCode);
    List<Byte> bytes = new ArrayList<>();

    if (optimise) {
      this.optimise(tokens);
    }

    // Cannot use streams
    for (Token token : tokens) {
      for (byte b : token.getBytes()) {
        bytes.add(b);
      }
    }

    // Cannot use streams
    byte[] data = new byte[bytes.size()];
    for (int i = 0; i < bytes.size(); i++) {
      data[i] = bytes.get(i);
    }

    return data;
  }

  /**
   * Extract tokens from the given source code.
   *
   * @param srcCode The source code to parse.
   */
  private List<Token> extractTokens(final String[] srcCode)
      throws UnknownInstructionException {
    // Tokens are sorted in reverse order to avoid name clashes when parsing
    List<Token> sortedTokens = Tokens.TOKENS.stream()
        .sorted((t1, t2) -> -t1.getInstruction(this.language).compareTo(t2.getInstruction(this.language)))
        .collect(Collectors.toList());
    List<Token> tokens = new ArrayList<>();

    for (int i = 0; i < srcCode.length; i++) {
      String line = srcCode[i];

      line = line.replaceAll("(?<!\\\\)((\\\\{2})*)\\^\\(_?-1\\)", "$1⁻¹")
          .replaceAll("(?<!\\\\)((\\\\{2})*)\\^\\(2\\)", "$1²")
          .replaceAll("(?<!\\\\)((\\\\{2})*)\\^\\(3\\)", "$1³");

      int lineLength = line.length();
      final String errorLine = srcCode[i];
      int index = 0;
      boolean escapeNext = false;

      while (index < lineLength) {
        if (!escapeNext && line.charAt(index) == '#') {
          index = lineLength;
        } else if (line.charAt(index) == '\\') {
          escapeNext = true;
          index++;
        } else {
          boolean found = false;

          for (Token token : sortedTokens) {
            String instr = token.getInstruction(this.language);
            int instrLength = instr.length();

            if (instrLength > lineLength - index || escapeNext && instrLength > 1) {
              continue;
            }

            if (line.startsWith(instr, index)) {
              tokens.add(token);

              escapeNext = false;
              found = true;
              index += instrLength;
              break;
            }
          }

          if (!found) {
            throw new UnknownInstructionException(errorLine, i + 1, index + 1);
          }
        }
      }

      tokens.add(Tokens.LINE_END);
    }

    return tokens;
  }

  /**
   * Optimize the given sequence of tokens.
   */
  @SuppressWarnings("OptionalGetWithoutIsPresent")
  private void optimise(List<Token> tokens) {
    final Token CLOSED_PAREN = Tokens.getToken(this.language, ")").get();
    final Token CLOSED_BRACE = Tokens.getToken(this.language, "}").get();
    final Token QUOTE = Tokens.getToken(this.language, "\"").get();
    final Token ARROW = Tokens.getToken(this.language, "->").get();
    final Token COLON = Tokens.getToken(this.language, ":").get();
    final Token STAR = Tokens.getToken(this.language, "*").get();

    boolean inString = false;
    boolean changed;
    do {
      changed = false;

      for (int i = 0; i < tokens.size(); i++) {
        Token previous = i > 0 ? tokens.get(i - 1) : null;
        Token token = tokens.get(i);
        Token next = i < tokens.size() - 1 ? tokens.get(i + 1) : null;

        boolean isStar = STAR.equals(token);
        boolean isQuote = QUOTE.equals(token);
        boolean isClosedParen = CLOSED_PAREN.equals(token);
        boolean nextIsNewLine = Tokens.isNewLine(next);

        boolean ignoreToken = false;
        if (inString || !isStar || (!Tokens.isNewLine(previous) && !nextIsNewLine)) {
          ignoreToken = (
              (ARROW.equals(next) || nextIsNewLine) && (
                  (inString && isQuote) || (!inString && (isClosedParen || CLOSED_BRACE.equals(token)))
              )
          ) || (
              !inString && (
                  (isClosedParen && COLON.equals(next))
                      || (isStar && (previous != null && Tokens.isNonDigit(previous) || next != null && Tokens.isNonDigit(next)))
              )
          );
        }

        if (ignoreToken) {
          changed = true;
          tokens.remove(i);
          i--;
        }

        if (Tokens.isNewLine(token) || ARROW.equals(token)) {
          inString = false;
        } else if (isQuote) {
          inString = !inString;
        }
      }
    } while (changed);
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
   * Replaces all aliases ({@code &amp;&lt;name>;}) by the corresponding instruction.
   */
  private void replaceAliases(String[] srcCode) {
    for (int i = 0; i < srcCode.length; i++) {
      for (Map.Entry<LocalizedAlias, String> entry : Tokens.ALIASES.entrySet()) {
        LocalizedAlias alias = entry.getKey();
        if (alias.isForLanguage(this.language)) {
          srcCode[i] = srcCode[i].replaceAll("&" + alias.getAlias() + ";", entry.getValue());
        }
      }
    }
  }
}
