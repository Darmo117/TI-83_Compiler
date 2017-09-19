package net.darmo_creations.ti83_compiler.exceptions;

public class UnknownTokenException extends Exception {
  private static final long serialVersionUID = 1149575004887338560L;

  public UnknownTokenException(byte token) {
    super("Unknown token 0x" + toHexString(token));
  }

  private static String toHexString(byte b) {
    String str = Integer.toHexString(b);

    return str.substring(str.length() - 2);
  }
}