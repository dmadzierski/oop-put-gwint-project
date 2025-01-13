package com.gwint;

import com.gwint.card.core.DbObject;
import com.gwint.card.core.Nation;
import com.gwint.card.core.Zone;
import com.gwint.card.special.DummyCard;
import com.gwint.card.special.HornCard;
import com.gwint.card.special.WeakenWeatherCard;

import javax.smartcardio.Card;
import java.util.*;
import java.util.stream.IntStream;

public class MainController {
  public MainController() {
  }

  public static void main(String[] args) {
    Set<DbObject> dbObjects = new HashSet();
    DummyCard dummyCard = new DummyCard("Dummy", "Swap with a card on the battlefield to return it to your hand.", Nation.NEUTRAL, 5);
    HornCard hornCard = new HornCard("Commander's Horn", "Doubles the strength of all unit cards in that row. Limited to 1 per row.", Nation.NEUTRAL, 2);
    WeakenWeatherCard bitingFrost = new WeakenWeatherCard("Biting Frost", "Sets the strength of all Close Combat cards to 1 for both players.", Nation.NEUTRAL, 2, Zone.CLOSE);
    dbObjects.add(dummyCard);
    dbObjects.add(hornCard);
    dbObjects.add(bitingFrost);
    dbObjects.forEach((k) -> {
      System.out.println(k.stats());
    });
  }

  static void mainLoop() {
    List<DbObject> dbObjects = new ArrayList();

    while(true) {
      List<Action> actions = new ArrayList(List.of(Action.values()));
      if (dbObjects.isEmpty()) {
        actions.remove(Action.REMOVE);
      }

      Action var2 = chooseAction(actions);
    }
  }

  private static List<Class> getCardType() {
    return new ArrayList(List.of(Card.class));
  }

  static Action chooseAction(List<Action> actions) {
    System.out.println("Choose action by writing first number in a row");
    IntStream.iterate(0, (i) -> {
      return i + 1;
    }).limit((long)actions.size()).forEachOrdered((a) -> {
      System.out.println(a + 1 + ". " + actions.get(a));
    });
    Integer choose = getIntegerFromUser(IntStream.range(0, actions.size()).boxed().toList());
    return (Action)actions.get(choose - 1);
  }

  static Integer getIntegerFromUser(List<Integer> possibleNumbers) {
    boolean isValid = false;

    do {
      Scanner scanner = new Scanner(System.in);
      String line = scanner.nextLine();
      isValid = line.matches("[0-9]+");
      if (isValid) {
        int num = Integer.parseInt(line);
        Iterator var5 = possibleNumbers.iterator();

        while(var5.hasNext()) {
          Integer possibleNumber = (Integer)var5.next();
          if (possibleNumber.equals(num)) {
            return num;
          }
        }
      }
    } while(!isValid);

    throw new RuntimeException("Something went wrong");
  }
}

