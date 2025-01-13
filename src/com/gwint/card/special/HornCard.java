package com.gwint.card.special;

import com.gwint.card.core.Nation;

public class HornCard extends SpecialCard {
  private Integer boostPower;

  public HornCard(String name, String description, Nation nation, Integer boostPower) {
    super(name, description, nation);
    this.boostPower = boostPower;
  }

  public void doAction() {
    System.out.println("I boost power of units on board by " + this.boostPower);
  }

  public String stats() {
    return "Id: %s | Name: %s | Description %s | Nation: %s | Boost power: %s".formatted(super.getId(), super.getName(), super.getDescription(), super.getNation(), this.boostPower);
  }
}
