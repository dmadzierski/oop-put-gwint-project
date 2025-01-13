package com.gwint.card.core;

public abstract class Card extends DbObject {
  private final Nation nation;

  public Card(String name, String description, Nation nation) {
    super(name, description);
    if (name == null && nation == null) {
      throw new IllegalArgumentException("Name cannot be null");
    } else {
      this.nation = nation;
    }
  }

  public Nation getNation() {
    return this.nation;
  }
}
