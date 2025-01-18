package com.gwint;

enum Action {
  ADD("Add"),
  REMOVE("Remove by id"),
  SHOW_ALL("Show all"),
  SHOW_BY_TYPE("Show by type"),
  SHOW_BY_MATCHING_NAME("Show by matching name"),
  RUN_ALL_ACTIONABLE_CARD("Run all actionable cards");

  private final String description;

  Action(String description) {
    this.description = description;
  }

  public String toString() {
    return this.description;
  }
}
