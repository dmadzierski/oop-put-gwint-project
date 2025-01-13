package com.gwint.card.unit;

import com.gwint.card.core.Actionable;
import com.gwint.card.core.Nation;
import com.gwint.card.core.Zone;

public class ScorchCard extends UnitCard implements Actionable {
  private Integer maxScorchPower;

  public ScorchCard(String name, String description, int power, boolean isHero, Zone combatZone, Nation nation, Integer maxScorchPower) {
    super(name, description, power, isHero, combatZone, nation);
    this.maxScorchPower = maxScorchPower;
  }

  public void doAction() {
    System.out.println("Scorch can beat the strongest card less or equal " + this.maxScorchPower);
  }
}
