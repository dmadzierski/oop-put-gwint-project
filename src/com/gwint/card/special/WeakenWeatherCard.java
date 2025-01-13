package com.gwint.card.special;

import com.gwint.card.core.Nation;
import com.gwint.card.core.Zone;

import java.io.PrintStream;

public class WeakenWeatherCard extends SpecialCard {
  private Integer weaknessPower;
  private Zone weakenZone;

  public WeakenWeatherCard(String name, String description, Nation nation, Integer weaknessPower, Zone weakenZone) {
    super(name, description, nation);
    this.weaknessPower = weaknessPower;
    this.weakenZone = weakenZone;
  }

  public void doAction() {
    PrintStream var10000 = System.out;
    String var10001 = this.weakenZone.getName().toLowerCase();
    var10000.println("Weakens the " + var10001 + " zone by dividing strength by " + this.weaknessPower);
  }

  public String stats() {
    return "Id: %s | Name: %s | Description %s | Nation: %s | Weakness power: %s | Weaken zone %s".formatted(super.getId(), super.getName(), super.getDescription(), super.getNation(), this.weaknessPower, this.weakenZone);
  }
}
