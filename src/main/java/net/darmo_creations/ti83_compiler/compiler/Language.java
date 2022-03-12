package net.darmo_creations.ti83_compiler.compiler;

/**
 * This enumeration defines all available languages.
 */
public enum Language {
  ENGLISH("en"),
  FRENCH("fr");

  private final String code;

  Language(final String code) {
    this.code = code;
  }

  /**
   * Return this language’s code.
   */
  public String getCode() {
    return this.code;
  }

  @Override
  public String toString() {
    return this.code;
  }

  /**
   * Return the {@link Language} instance for the given code.
   *
   * @param code A language code.
   * @return The instance or null if not matched.
   */
  public static Language fromCode(final String code) {
    for (Language language : values()) {
      if (language.getCode().equals(code)) {
        return language;
      }
    }
    return null;
  }
}
