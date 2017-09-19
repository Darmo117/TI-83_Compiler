package net.darmo_creations.ti83_compiler.compilers;

public class Token {
  private String instruction;
  private String language;
  private byte[] token;

  public Token(String instruction, byte[] token) {
    this(instruction, null, token);
  }

  public Token(String instruction, String language, byte[] token) {
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
