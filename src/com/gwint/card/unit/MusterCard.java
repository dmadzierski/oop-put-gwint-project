package com.gwint.card.unit;

import com.gwint.card.core.Actionable;
import com.gwint.card.core.Nation;
import com.gwint.card.core.Zone;

public class MusterCard extends UnitCard implements Actionable {
  public MusterCard(String name, String description, int power, boolean isHero, Zone combatZone, Nation nation) {
    super(name, description, power, isHero, combatZone, nation);
  }

  public void doAction() {
    System.out.println("I can summon other units cards");
  }
}
