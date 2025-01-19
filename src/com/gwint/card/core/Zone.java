package com.gwint.card.core;

import com.gwint.card.util.StringUtils;

public enum Zone {
    CLOSE("Close"),
    RANGE("Range"),
    SIEGE("Siege");

    private final String name;

    private Zone(String name) {
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
