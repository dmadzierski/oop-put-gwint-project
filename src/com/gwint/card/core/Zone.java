package com.gwint.card.core;

public enum Zone {
  CLOSE("Close"),
  RANGE("Range"),
  SIEGE("Siege");

  private final String name;

  private Zone(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
