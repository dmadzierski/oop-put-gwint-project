package com.gwint.card.unit;

import com.gwint.card.core.Actionable;
import com.gwint.card.core.Nation;
import com.gwint.card.core.Zone;

public class MoraleBoostCard extends UnitCard implements Actionable {
  private Integer boostPower;

  public MoraleBoostCard(String name, String description, int power, boolean isHero, Zone combatZone, Nation nation, Integer boostPower) {
    super(name, description, power, isHero, combatZone, nation);
    this.boostPower = boostPower;
  }

  public void doAction() {
    System.out.println("Support companion in my line by " + this.boostPower);
  }
}
