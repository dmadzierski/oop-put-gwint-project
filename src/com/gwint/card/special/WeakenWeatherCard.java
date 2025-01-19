package com.gwint.card.special;

import com.gwint.card.core.Nation;
import com.gwint.card.core.Zone;

public class WeakenWeatherCard extends SpecialCard {
    private Integer weaknessPower;
    private Zone weakenZone;

    public WeakenWeatherCard(String name, String description, Nation nation, Integer weaknessPower, Zone weakenZone) {
        super(name, description, nation);
        if (weaknessPower == null || weaknessPower < 1)
            throw new IllegalArgumentException("Weakness power is not valid");
        if (weakenZone == null)
            throw new IllegalArgumentException("Weaken zone is not valid");
        this.weaknessPower = weaknessPower;
        this.weakenZone = weakenZone;
    }

    public void doAction() {
        System.out.printf("%s | I boost power of units on board by %s\n", super.getName(), this.weaknessPower);
    }

    public String info() {
        return "Id: %s | Name: %s | Description %s | Nation: %s | Weakness power: %s | Weaken zone %s"
                .formatted(super.getId(), super.getName(), super.getDescription(), super.getNation(), this.weaknessPower, this.weakenZone);
    }

}
