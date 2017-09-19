package net.darmo_creations.ti83_compiler.exceptions;

import java.text.ParseException;

public class UnknownInstructionException extends ParseException {
  private static final long serialVersionUID = 7946406948464110260L;

  private int colOffset;

  public UnknownInstructionException(String s, int lineOffset, int colOffset) {
    super(s, lineOffset);
    this.colOffset = colOffset;
  }

  public int getColumnOffset() {
    return this.colOffset;
  }
}
