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
        if (strength == null || strength < 0)
            throw new IllegalArgumentException("Strength is not valid");
        if (combatZone == null)
            throw new IllegalArgumentException("Zone combat is not valid");
        if (isHero == null)
            isHero = false;
        this.strength = strength;
        this.isHero = isHero;
        this.combatZone = combatZone;
    }

    public Boolean couldHero() {
        return isHero;
    }

    public Integer getStrength() {
        return strength;
    }

    public Zone getCombatZone() {
        return combatZone;
    }

    public String info() {
        return "Id: %s | Name: %s | Description %s | Nation: %s  | Strength: %s | Hero: %s | CombatZone: %s | Nation: %s"
                .formatted(super.getId(), super.getName(), super.getDescription(), super.getNation(), this.strength, this.isHero, this.combatZone, super.getNation());
    }


}
