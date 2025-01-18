package com.gwint;

import com.gwint.card.core.Actionable;
import com.gwint.card.core.Card;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CardController {

  private TreeSet<Card> dbObjects = new TreeSet<>(Comparator.comparingInt(Card::getId));

  public CardController(Set<Card> dbObjects) {
    this.dbObjects.addAll(dbObjects);
  }

  public CardController() {
  }

  void removeCard(Integer id) {
    Card objectToRemove = dbObjects.stream().filter(card -> card.getId().equals(id)).findFirst().
      orElseThrow(() -> new RuntimeException("Card.java not found"));
    dbObjects.remove(objectToRemove);
  }

  void showCardsByName(String phrase) {
    TreeSet<Card> filteredDbObjects = this.dbObjects.stream()
      .filter(card -> card.getName().toLowerCase().contains(phrase.toLowerCase()))
      .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingInt(Card::getId))));
    if (filteredDbObjects.isEmpty())
      throw new RuntimeException("No cards found");
    else
      filteredDbObjects.forEach((o) -> System.out.println(o.info()));

  }

  void runAllActionableCards() {
    this.dbObjects.stream()
      .filter(Actionable.class::isInstance)
      .map(Actionable.class::cast)
      .forEach(Actionable::doAction);
  }

  void showAllDbObjects() {
    if (!dbObjects.isEmpty())
      dbObjects.forEach((o) -> System.out.println(o.info()));
    else
      System.out.println("No db objects found");
  }


  public boolean isEmpty() {
    return this.dbObjects.isEmpty();
  }

  public void showCardsByType(Class<?> cardsSubType) {
    TreeSet<Card> filteredDbObjects = this.dbObjects.stream().filter(o -> o.getClass().isAssignableFrom(cardsSubType))
      .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingInt(Card::getId))));
    if (filteredDbObjects.isEmpty())
      throw new RuntimeException("No cards found");
    else
      filteredDbObjects.forEach((o) -> System.out.println(o.info()));
  }
}

