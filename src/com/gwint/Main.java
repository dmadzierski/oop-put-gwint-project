package com.gwint;

import com.gwint.card.core.Nation;
import com.gwint.card.special.DummyCard;
import com.gwint.card.special.HornCard;
import com.gwint.card.special.WeakenWeatherCard;
import com.gwint.card.unit.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {


  private static Class<?>[] cardsSubTypes = {DummyCard.class, HornCard.class, WeakenWeatherCard.class, UnitCard.class, MedicCard.class, MoraleBoostCard.class, ScorchCard.class, SpyCard.class};


  public static void main(String[] args) {
    CardController cardController = new CardController(ExampleCards.exampleCards);
    mainLoop(cardController);
  }

  private static void mainLoop(CardController cardController) {
    UserInput userInput = new UserInput();
    while (true) {
      List<Action> actions = new ArrayList<>(List.of(Action.values()));
      if (cardController.isEmpty()) {
        actions.remove(Action.REMOVE);
      }
      Action chossedAction = Main.chooseAction(actions);
      switch (chossedAction) {
        case ADD -> {
          IntStream.range(0, cardsSubTypes.length).forEachOrdered(i -> System.out.printf("%s: %s%n", (i + 1), cardsSubTypes[i].getSimpleName()));
          System.out.println("Write the number next to the type name to create new card");
          Integer cardType = (userInput.getIntegerFromUser() - 1);
          String name = userInput.getNotEmptyStringFromUser();
          String description = userInput.getNotEmptyStringFromUser();
          Integer nationNumber = userInput.getIntegerInListFromUser(Stream.iterate(0, k -> k + 1).limit(Nation.values().length).toList());
          Nation nation = Nation.values()[nationNumber];
          Class<UnitCard> unitCardClass = UnitCard.class;


        }
        case REMOVE -> {
          System.out.println("Write id of object which you want to remove");
          Integer id = userInput.getIntegerFromUser();
          try {
            cardController.removeCard(id);
            System.out.println("Card.java removed");
          } catch (RuntimeException e) {
            System.err.println(e.getMessage());
          }
        }
        case SHOW_ALL -> {
          cardController.showAllDbObjects();
        }
//        TODO
        case SHOW_BY_TYPE -> {
          IntStream.range(0, cardsSubTypes.length).forEachOrdered(i -> System.out.printf("%s: %s\n", (i + 1), cardsSubTypes[i].getSimpleName()));
          System.out.println("Write the number next to the type name to filter by him");
          try {
            Integer integerFromUser = userInput.getIntegerInListFromUser(IntStream.range(1, cardsSubTypes.length).boxed().toList()) - 1;
            cardController.showCardsByType(cardsSubTypes[integerFromUser]);
          } catch (Exception e) {
            System.err.println(e.getMessage());
          }
        }
        case SHOW_BY_MATCHING_NAME -> {
          System.out.println("Write phrase to filtering by card name");
          String phrase = userInput.getNotEmptyStringFromUser();
          try {
            cardController.showCardsByName(phrase);
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
        }
        case RUN_ALL_ACTIONABLE_CARD -> {
          cardController.runAllActionableCards();
        }
      }
    }
  }

  private static Action chooseAction(List<Action> actions) {
    UserInput userInput = new UserInput();
    System.out.println("Choose action by writing first number in a row");
    IntStream.iterate(0, (i) -> i + 1).limit(actions.size()).forEachOrdered((a) -> System.out.println(a + 1 + ". " + actions.get(a)));
    Integer choose = userInput.getIntegerInListFromUser(IntStream.range(1, (actions.size() + 1)).boxed().toList());
    return actions.get(choose - 1);
  }


}
