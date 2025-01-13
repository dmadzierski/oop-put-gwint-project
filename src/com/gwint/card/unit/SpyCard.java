package com.gwint.card.unit;

import com.gwint.card.core.Actionable;
import com.gwint.card.core.Nation;
import com.gwint.card.core.Zone;

public class SpyCard extends UnitCard implements Actionable {
  private Integer extraCardNumber;

  public SpyCard(String name, String description, int power, boolean isHero, Zone combatZone, Nation nation, Integer extraCardNumber) {
    super(name, description, power, isHero, combatZone, nation);
    this.extraCardNumber = extraCardNumber;
  }

  public void doAction() {
  }
}
