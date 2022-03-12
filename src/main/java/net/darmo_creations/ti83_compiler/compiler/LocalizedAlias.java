package net.darmo_creations.ti83_compiler.compiler;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This class represents an alias of a token for certain languages.
 */
class LocalizedAlias {
  private final List<Language> languages;
  private final String alias;

  /**
   * Create an alias for the given languages.
   *
   * @param alias     The alias.
   * @param languages The languages.
   */
  public LocalizedAlias(final String alias, final Language... languages) {
    this.languages = Arrays.stream(languages).collect(Collectors.toList());
    this.alias = Objects.requireNonNull(alias);
  }

  /**
   * Create an alias for all languages.
   *
   * @param alias The alias.
   */
  public LocalizedAlias(final String alias) {
    this(alias, Language.values());
  }

  /**
   * Check whether this alias is available in the given language.
   *
   * @param language The language.
   * @return True if this alias is available for the language, false otherwise.
   */
  public boolean isForLanguage(final Language language) {
    return this.languages.contains(language);
  }

  /**
   * Return the alias.
   */
  public String getAlias() {
    return this.alias;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    LocalizedAlias that = (LocalizedAlias) o;
    return this.alias.equals(that.alias);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.alias);
  }
}
