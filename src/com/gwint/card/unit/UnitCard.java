package com.gwint.card.unit;

import com.gwint.card.core.Card;
import com.gwint.card.core.Nation;
import com.gwint.card.core.Zone;

public class UnitCard extends Card {
  private Integer strength;
  private Boolean isHero;
  private Zone combatZone;

  public UnitCard(String name, String description, Integer strength, Boolean isHero, Zone combatZone, Nation nation) {
    super(name, description, nation);
    this.strength = strength;
    this.isHero = isHero;
    this.combatZone = combatZone;
  }

  public String stats() {
    return "";
  }
}
