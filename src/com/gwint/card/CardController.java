package com.gwint.card;

import com.gwint.card.util.UserInput;
import com.gwint.card.core.Card;
import com.gwint.card.special.DummyCard;
import com.gwint.card.special.HornCard;
import com.gwint.card.special.WeakenWeatherCard;
import com.gwint.card.unit.*;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;


public class CardController {


    private final UserInput userInput = new UserInput();
    private final CardService cardService;
    private final CardCreator cardCreator = new CardCreator();
    private final HashMap<Class<?>, Callable<? extends Card>> cardSubtypeCreator = new HashMap<>(Map.of(
            DummyCard.class, cardCreator::createUnitCard,
            HornCard.class, cardCreator::createHornCard,
            WeakenWeatherCard.class, cardCreator::createWeakenWeatherCard,
            UnitCard.class, cardCreator::createUnitCard,
            MedicCard.class, cardCreator::createMedicCard,
            MoraleBoostCard.class, cardCreator::createMoraleBoostCard,
            ScorchCard.class, cardCreator::createScorchCard,
            SpyCard.class, cardCreator::createSpyCard
    ));

    private final Class<?>[] cardSubtypes = cardSubtypeCreator.keySet().toArray(new Class[0]);

    public CardController(HashSet<Card> exampleCards) {
        this.cardService = new CardService(exampleCards);
    }

    public CardController() {
        this.cardService = new CardService();
    }

    public void mainLoop() {
        loop:
        while (true) {
            List<Action> actions = new ArrayList<>(List.of(Action.values()));
            if (cardService.isEmpty()) {
                actions.remove(Action.REMOVE);
            }
            switch (this.chooseAction(actions)) {
                case ADD -> addCard(cardService);
                case REMOVE -> removeCard(cardService);
                case SHOW_ALL -> showCards(cardService);
                case SHOW_BY_TYPE -> showCardsByType(cardService);
                case SHOW_BY_MATCHING_NAME -> showCardsByMatchingName(cardService);
                case RUN_ALL_ACTIONABLE_CARD -> runAllActionableCards(cardService);
                default -> {
                    break loop;
                }
            }
        }
    }

    private void runAllActionableCards(CardService cardService) {
        cardService.runAllActionableCards();
    }

    private void showCardsByMatchingName(CardService cardService) {
        System.out.println("Write phrase to filtering by card name");
        String phrase = userInput.getNotEmptyStringFromUser();
        try {
            cardService.showCardsByName(phrase);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void showCardsByType(CardService cardService) {
//        TODO
        IntStream.range(0, cardSubtypes.length).forEachOrdered(i -> System.out.printf("%s: %s\n", (i + 1), cardSubtypes[i].getSimpleName()));
        System.out.println("Write the number next to the type name to filter by him");
        try {
            Integer integerFromUser = userInput.getIntegerInListFromUser(IntStream
                    .iterate(1, k -> k + 1).limit(cardSubtypes.length).boxed().toList()) - 1;
            cardService.showCardsByType(cardSubtypes[integerFromUser]);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void showCards(CardService cardService) {
        cardService.showAllCards();
    }

    private void removeCard(CardService cardService) {
        System.out.println("Write id of object which you want to remove");
        cardService.showAllCards();
        Integer id = userInput.getIntegerFromUser();
        try {
            cardService.removeCard(id);
            System.out.println("Card removed");
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    private void addCard(CardService cardService) {
        IntStream.range(0, cardSubtypes.length).forEachOrdered(i -> System.out.printf("%s: %s\n", (i + 1), cardSubtypes[i].getSimpleName()));
        System.out.println("Write the number next to the type name to create new card");
        Integer subtypeNumber = userInput.getIntegerInListFromUser(IntStream.iterate(1, k -> k + 1).limit(cardSubtypes.length).boxed().toList()) - 1;
        Card call = null;
        try {
            call = cardSubtypeCreator.get(cardSubtypes[subtypeNumber]).call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        cardService.addCard(call);
    }

    private Action chooseAction(List<Action> actions) {
        System.out.println("\nChoose action by writing first number in a row");
        IntStream.iterate(0, (i) -> i + 1).limit(actions.size()).forEachOrdered((a) -> System.out.println(a + 1 + ". " + actions.get(a)));
        Integer choose = userInput.getIntegerInListFromUser(IntStream.range(1, (actions.size() + 1)).boxed().toList());
        return actions.get(choose - 1);
    }
}

enum Action {
    ADD("Add"),
    REMOVE("Remove by id"),
    SHOW_ALL("Show all"),
    SHOW_BY_TYPE("Show by type"),
    SHOW_BY_MATCHING_NAME("Show by matching name"),
    RUN_ALL_ACTIONABLE_CARD("Run all actionable cards"),
    EXIT("Close program");

    private final String description;

    Action(String description) {
        this.description = description;
    }

    public String toString() {
        return this.description;
    }
}