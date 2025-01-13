package com.gwint.card.special;

import com.gwint.card.core.Nation;

public class DummyCard extends SpecialCard {
  private Integer maxStrengthSwap;

  public DummyCard(String name, String description, Nation nation, Integer maxStrengthSwap) {
    super(name, description, nation);
    this.maxStrengthSwap = maxStrengthSwap;
  }

  public void doAction() {
    System.out.println("Swap any unit card to " + this.maxStrengthSwap + " of strength");
  }

  public String stats() {
    return "Id: %s | Name: %s | Description %s | Nation: %s | Max strength to swap: %s".formatted(super.getId(), super.getName(), super.getDescription(), super.getNation(), this.maxStrengthSwap);
  }
}
