package com.gwint.card.special;

import com.gwint.card.core.Nation;

public class HornCard extends SpecialCard {
  private Integer boostPower;

  public HornCard(String name, String description, Nation nation, Integer boostPower) {
    super(name, description, nation);
    if (boostPower == null || boostPower < 1)
      throw new IllegalArgumentException("Boost power is not valid");
    this.boostPower = boostPower;
  }

  public void doAction() {
    System.out.printf("%s | I boost power of units on board by %s\n", super.getName(), this.boostPower);
  }

  public String info() {
    return "Id: %s | Name: %s | Description %s | Nation: %s | Boost power: %s".formatted(super.getId(), super.getName(), super.getDescription(), super.getNation(), this.boostPower);
  }
}
