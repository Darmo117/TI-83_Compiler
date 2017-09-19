package net.darmo_creations.ti83_compiler.compilers;

/**
 * This class represents an instruction token.
 *
 * @author Damien Vergnet
 */
public class Token {
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

  public byte[] getToken() {
    return this.token;
  }
}
