package com.gwint.card.unit;

import com.gwint.card.core.Actionable;
import com.gwint.card.core.Nation;
import com.gwint.card.core.Zone;

public class MedicCard extends UnitCard implements Actionable {
    private Integer maxHealedStrength;

    public MedicCard(String name, String description, Integer strength, Boolean isHero, Zone combatZone, Nation nation, Integer maxHealedStrength) {
        super(name, description, strength, isHero, combatZone, nation);
        if (maxHealedStrength == null || maxHealedStrength < 1)
            throw new IllegalArgumentException("Max healed strength is not valid");
        this.maxHealedStrength = maxHealedStrength;
    }

    public void doAction() {
        System.out.printf("%s | Resurrect dead units to %s of strength\n", this.getName(), this.maxHealedStrength);
    }

    @Override
    public String info() {
        return "%s | Max healed strength: %s"
                .formatted(super.info(), this.maxHealedStrength);
    }
}
