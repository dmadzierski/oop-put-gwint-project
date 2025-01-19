package com.gwint.card.core;

public abstract class Card {
    private final Integer id = IdManager.getNextCardId();
    private final Nation nation;
    private String name;
    private String description;

    public Card(String name, String description, Nation nation) {
        if (name == null)
            throw new IllegalArgumentException("Name cannot be null");
        else if (nation == null)
            throw new IllegalArgumentException("Nation cannot be null");
        else {
            this.name = name;
            this.description = description;
            this.nation = nation;
        }
    }

    public Nation getNation() {
        return this.nation;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public abstract String info();

}

class IdManager {
    private static Integer nextCardId = 0;

    static Integer getNextCardId() {
        return nextCardId++;
    }
}

