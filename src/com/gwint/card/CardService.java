package com.gwint.card;

import com.gwint.card.core.Actionable;
import com.gwint.card.core.Card;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CardService {

    private final TreeSet<Card> cards = new TreeSet<>(Comparator.comparingInt(Card::getId));

    public CardService(Set<Card> cards) {
        this.cards.addAll(cards);
    }

    public CardService() {
    }

    void removeCard(Integer id) {
        Card objectToRemove = cards.stream().filter(card -> card.getId().equals(id)).findFirst().
                orElseThrow(() -> new RuntimeException("Card.java not found"));
        cards.remove(objectToRemove);
    }

    void showCardsByName(String phrase) {
        TreeSet<Card> filteredDbObjects = this.cards.stream()
                .filter(card -> card.getName().toLowerCase().contains(phrase.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingInt(Card::getId))));
        if (filteredDbObjects.isEmpty())
            throw new RuntimeException("No cards found");
        else
            filteredDbObjects.forEach((o) -> System.out.println(o.info()));

    }

    void runAllActionableCards() {
        this.cards.stream()
                .filter(Actionable.class::isInstance)
                .map(Actionable.class::cast)
                .forEach(Actionable::doAction);
    }

    void showAllCards() {
        if (!cards.isEmpty())
            cards.forEach((o) -> System.out.println(o.info()));
        else
            System.out.println("No db objects found");
    }

    boolean isEmpty() {
        return this.cards.isEmpty();
    }

    void showCardsByType(Class<?> cardsSubType) {
        TreeSet<Card> filteredDbObjects = this.cards.stream().filter(o -> o.getClass().getName().equals(cardsSubType.getName()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingInt(Card::getId))));
        if (filteredDbObjects.isEmpty())
            throw new RuntimeException("No cards found");
        else
            filteredDbObjects.forEach((o) -> System.out.println(o.info()));
    }

    void addCard(Card card) {
        this.cards.add(card);
    }

}

