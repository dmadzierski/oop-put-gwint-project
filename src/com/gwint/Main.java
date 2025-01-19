package com.gwint;

import com.gwint.card.CardController;

public class Main {
    public static void main(String[] args) {
        CardController cardController = new CardController(ExampleCards.exampleCards);
        cardController.mainLoop();
    }
}
