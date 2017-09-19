package net.darmo_creations.ti83_compiler.exceptions;

public class FileFormatException extends Exception {
  private static final long serialVersionUID = 5509763941234316146L;

  public FileFormatException(String msg) {
    super(msg);
  }

  public FileFormatException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
