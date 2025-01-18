package com.gwint.card.unit;

import com.gwint.card.core.Actionable;
import com.gwint.card.core.Nation;
import com.gwint.card.core.Zone;

public class ScorchCard extends UnitCard implements Actionable {
  private Integer maxScorchPower;

  public ScorchCard(String name, String description, Integer power, Boolean isHero, Zone combatZone, Nation nation, Integer maxScorchPower) {
    super(name, description, power, isHero, combatZone, nation);
    if (maxScorchPower == null || maxScorchPower < 0)
      throw new IllegalArgumentException("Max scorch power is not valid");
    this.maxScorchPower = maxScorchPower;
  }

  public void doAction() {
    System.out.printf("%s | Scorch can beat the strongest card less or equal %s\n", getName(), this.maxScorchPower);
  }

  @Override
  public String info() {
    return "%s | Max scorch power: %s".formatted(super.info(), this.maxScorchPower);
  }
}
