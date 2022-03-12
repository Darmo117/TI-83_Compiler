package net.darmo_creations.ti83_compiler.compiler;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/**
 * This class represents an instruction token.
 * <p>
 * Tokens are comparable. Comparison is performed based on the token’s bytes.
 *
 * @author Damien Vergnet
 */
public class Token {
  private final Map<Language, String> instructions;
  private final byte[] bytes;

  /**
   * Creates a token.
   *
   * @param bytes Bytes for this token.
   */
  public Token(final byte... bytes) {
    this.instructions = new EnumMap<>(Language.class);
    if (bytes.length == 0) {
      throw new IllegalArgumentException("token should be at least one byte long");
    }
    this.bytes = Arrays.copyOf(bytes, bytes.length);
  }

  /**
   * Add an instruction in the given languages for this token.
   *
   * @param instruction The instruction.
   * @param languages   Languages for the instruction.
   * @return This token.
   */
  public Token instruction(final String instruction, final Language... languages) {
    for (Language language : languages) {
      this.instructions.put(language, instruction);
    }
    return this;
  }

  /**
   * Add an instruction that is identical for all languages.
   *
   * @param intruction The instruction.
   * @return This token.
   */
  public Token instruction(final String intruction) {
    return this.instruction(intruction, Language.values());
  }

  /**
   * Return this token’s instruction for the given language.
   */
  public String getInstruction(final Language language) {
    return this.instructions.get(language);
  }

  /**
   * Return this token’s bytes.
   */
  public byte[] getBytes() {
    return Arrays.copyOf(this.bytes, this.bytes.length);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Arrays.hashCode(this.bytes);
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Token) {
      return Arrays.equals(this.bytes, ((Token) o).bytes);
    }
    return false;
  }

  @Override
  public String toString() {
    return this.instructions.get(Language.ENGLISH);
  }
}
