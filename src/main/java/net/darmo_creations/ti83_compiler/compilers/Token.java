package net.darmo_creations.ti83_compiler.compilers;

import java.util.Arrays;

/**
 * This class represents an instruction token.
 *
 * @author Damien Vergnet
 */
public class Token implements Comparable<Token> {
  private String instruction;
  private String language;
  private byte[] token;

  /**
   * Creates an unlocalized token.
   * 
   * @param instruction the source instruction
   * @param token the token (can be several bytes)
   */
  public Token(String instruction, byte... token) {
    this(instruction, null, token);
  }

  /**
   * Creates a localized token.
   * 
   * @param instruction the source instruction
   * @param language the language
   * @param token the byte token
   */
  public Token(String instruction, String language, byte... token) {
    this.instruction = instruction;
    this.language = language;
    this.token = token;
  }

  public String getInstruction() {
    return this.instruction;
  }

  public String getLanguage() {
    return this.language;
  }

  public byte[] getBytes() {
    return this.token;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Arrays.hashCode(this.token);
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Token)
      return Arrays.equals(this.token, ((Token) o).token);
    return false;
  }

  @Override
  public int compareTo(Token t) {
    int l1 = getInstruction().length();
    int l2 = t.getInstruction().length();

    if (l1 != l2)
      return l1 - l2;
    return getInstruction().compareTo(t.getInstruction());
  }

  @Override
  public String toString() {
    return this.instruction;
  }
}
