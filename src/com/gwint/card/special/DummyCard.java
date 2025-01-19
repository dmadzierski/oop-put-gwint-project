package com.gwint.card.special;

import com.gwint.card.core.Nation;

public class DummyCard extends SpecialCard {
    private Integer maxStrengthSwap;

    public DummyCard(String name, String description, Nation nation, Integer maxStrengthSwap) {
        super(name, description, nation);
        if (maxStrengthSwap == null || maxStrengthSwap < 0)
            throw new IllegalArgumentException("Max strength swap not valid");
        this.maxStrengthSwap = maxStrengthSwap;
    }

    public void doAction() {
        System.out.printf("%s | Swap any unit card to %s of strength\n", super.getName(), this.maxStrengthSwap);
    }

    public String info() {
        return "Id: %s | Name: %s | Description %s | Nation: %s | Max strength to swap: %s".formatted(super.getId(), super.getName(), super.getDescription(), super.getNation(), this.maxStrengthSwap);
    }

}
