package com.gwint.card.core;

public abstract class DbObject {
  private final int id = IdManager.getNextCardId();
  private String name;
  private String description;

  public DbObject(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public DbObject(String name) {
    this.name = name;
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public abstract String stats();

  class IdManager {
    private static int nextCardId = 0;

    static int getNextCardId() {
      return nextCardId++;
    }
  }

}
