package com.gwint.card.core;

import com.gwint.card.util.StringUtils;

public enum Nation {
    MONSTERS("Monsters"),
    NILFGAARDIAN("Nilfgaardian"),
    SCOIATAEL("Scoiatael"),
    SKELLIGE("Skellige"),
    NEUTRAL("Neutral");

    private final String name;

    private Nation(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return StringUtils.capitalCaseOf(this.name);
    }
}
