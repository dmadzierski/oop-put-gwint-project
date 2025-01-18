package com.gwint.card.unit;

import com.gwint.card.core.Actionable;
import com.gwint.card.core.Nation;
import com.gwint.card.core.Zone;

public class SpyCard extends UnitCard implements Actionable {
  private Integer extraCardNumber;

  public SpyCard(String name, String description, Integer power, Boolean isHero, Zone combatZone, Nation nation, Integer extraCardNumber) {
    super(name, description, power, isHero, combatZone, nation);
    if (extraCardNumber == null || extraCardNumber < 1)
      throw new IllegalArgumentException("Extra card number is not valid");
    this.extraCardNumber = extraCardNumber;
  }

  public void doAction() {
    System.out.printf("%s | Take %s extra card\n", super.getName(), this.extraCardNumber);
  }

  @Override
  public String info() {
    return "%s | Extra card: %s ".formatted(super.info(), this.extraCardNumber);
  }
}
