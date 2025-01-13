package com.gwint.card.unit;

import com.gwint.card.core.Actionable;
import com.gwint.card.core.Nation;
import com.gwint.card.core.Zone;

public class MedicCard extends UnitCard implements Actionable {
  private Integer maxHealedStrength;

  public MedicCard(String name, String description, int power, boolean isHero, Zone combatZone, Nation nation, Integer maxHealedStrength) {
    super(name, description, power, isHero, combatZone, nation);
    this.maxHealedStrength = maxHealedStrength;
  }

  public void doAction() {
    System.out.println("Resurrect dead units to " + this.maxHealedStrength + " of strength");
  }
}
