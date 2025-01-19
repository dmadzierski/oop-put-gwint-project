package com.gwint.card.unit;

import com.gwint.card.core.Actionable;
import com.gwint.card.core.Nation;
import com.gwint.card.core.Zone;

public class MoraleBoostCard extends UnitCard implements Actionable {
    private Integer boostPower;

    public MoraleBoostCard(String name, String description, Integer strength, Boolean isHero, Zone combatZone, Nation nation, Integer boostPower) {
        super(name, description, strength, isHero, combatZone, nation);
        if (boostPower == null || boostPower < 1)
            throw new IllegalArgumentException("Boost power is not valid");
        this.boostPower = boostPower;
    }

    public void doAction() {
        System.out.printf("%s | Support companion in my line by %s\n", this.getName(), this.boostPower);
    }

    @Override
    public String info() {
        return "%s | Boost power: %s".formatted(super.info(), this.boostPower);
    }
}
