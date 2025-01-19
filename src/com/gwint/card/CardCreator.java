package com.gwint.card;

import com.gwint.card.util.UserInput;
import com.gwint.card.constant.CardVariableName;
import com.gwint.card.core.Nation;
import com.gwint.card.core.Zone;
import com.gwint.card.special.DummyCard;
import com.gwint.card.special.HornCard;
import com.gwint.card.special.WeakenWeatherCard;
import com.gwint.card.unit.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static com.gwint.card.constant.CardVariableName.BOOST_POWER;
import static com.gwint.card.constant.CardVariableName.COMBAT_ZONE;
import static com.gwint.card.constant.CardVariableName.DESCRIPTION;
import static com.gwint.card.constant.CardVariableName.EXTRA_CARD_NUMBER;
import static com.gwint.card.constant.CardVariableName.MAX_HEALED_POWER;
import static com.gwint.card.constant.CardVariableName.MAX_SCORCH_POWER;
import static com.gwint.card.constant.CardVariableName.NAME;
import static com.gwint.card.constant.CardVariableName.NATION;
import static com.gwint.card.constant.CardVariableName.WEAKEN_ZONE;
import static com.gwint.card.constant.CardVariableName.WEAKNESS_POWER;

public class CardCreator {


    private UserInput userInput = new UserInput();

    public DummyCard createDummyCard() {
        Map<String, Object> data = getDataForCard();
        data.put(CardVariableName.MAX_STRENGTH_SWAP, getNumberGreaterThanZeroFromUser("Enter a max strength swap"));
        return new DummyCard((String) data.get(NAME), (String) data.get(DESCRIPTION), (Nation) data.get(NATION), (Integer) data.get(CardVariableName.MAX_STRENGTH_SWAP));
    }

    public HornCard createHornCard() {
        Map<String, Object> data = getDataForCard();
        data.put(BOOST_POWER, getPositiveNumberFromUser("Enter a boost power"));
        return new HornCard((String) data.get(NAME), (String) data.get(DESCRIPTION), (Nation) data.get(NATION), (Integer) data.get(BOOST_POWER));
    }

    public WeakenWeatherCard createWeakenWeatherCard() {
        Map<String, Object> data = getDataForCard();
        data.put(WEAKNESS_POWER, getPositiveNumberFromUser("Enter a weakness power"));
        data.put(WEAKEN_ZONE, getEnumValueFromUser("Enter a weaken zone for card by entering a number which is next to the zone name", Zone.class));
        return new WeakenWeatherCard((String) data.get(NAME), (String) data.get(DESCRIPTION), (Nation) data.get(NATION), (Integer) data.get(WEAKNESS_POWER), (Zone) data.get(WEAKEN_ZONE));
    }

    public MedicCard createMedicCard() {
        Map<String, Object> data = getDataForUnitCard();
        data.put(MAX_HEALED_POWER, getPositiveNumberFromUser("Enter a max healed strength"));
        return new MedicCard((String) data.get(NAME), (String) data.get(DESCRIPTION), (Integer) data.get(CardVariableName.STRENGTH), (Boolean) data.get(CardVariableName.IS_HERO), (Zone) data.get(COMBAT_ZONE), (Nation) data.get(NATION), (Integer) data.get(MAX_HEALED_POWER));
    }

    public MoraleBoostCard createMoraleBoostCard() {
        Map<String, Object> data = getDataForUnitCard();
        data.put(BOOST_POWER, getPositiveNumberFromUser("Enter a boost power"));
        return new MoraleBoostCard((String) data.get(NAME), (String) data.get(DESCRIPTION), (Integer) data.get(CardVariableName.STRENGTH), (Boolean) data.get(CardVariableName.IS_HERO), (Zone) data.get(COMBAT_ZONE), (Nation) data.get(NATION), (Integer) data.get(BOOST_POWER));
    }

    public ScorchCard createScorchCard() {
        Map<String, Object> data = getDataForUnitCard();
        data.put(MAX_SCORCH_POWER, getNumberGreaterThanZeroFromUser("Enter a max scorch power"));
        return new ScorchCard((String) data.get(NAME), (String) data.get(DESCRIPTION), (Integer) data.get(CardVariableName.STRENGTH), (Boolean) data.get(CardVariableName.IS_HERO), (Zone) data.get(COMBAT_ZONE), (Nation) data.get(NATION), (Integer) data.get(MAX_SCORCH_POWER));
    }

    public SpyCard createSpyCard() {
        Map<String, Object> data = getDataForUnitCard();
        data.put(EXTRA_CARD_NUMBER, getPositiveNumberFromUser("Enter a extra card number"));
        return new SpyCard((String) data.get(NAME), (String) data.get(DESCRIPTION), (Integer) data.get(CardVariableName.STRENGTH), (Boolean) data.get(CardVariableName.IS_HERO), (Zone) data.get(COMBAT_ZONE), (Nation) data.get(NATION), (Integer) data.get(EXTRA_CARD_NUMBER));
    }

    public UnitCard createUnitCard() {
        Map<String, Object> data = getDataForUnitCard();
        return new UnitCard((String) data.get(NAME), (String) data.get(DESCRIPTION), (Integer) data.get(CardVariableName.STRENGTH), (Boolean) data.get(CardVariableName.IS_HERO), (Zone) data.get(COMBAT_ZONE), (Nation) data.get(NATION));
    }

    private Map<String, Object> getDataForUnitCard() {
        Map<String, Object> data = getDataForCard();
        data.put(CardVariableName.STRENGTH, getNumberGreaterThanZeroFromUser("Enter a strength for card"));
        data.put(CardVariableName.IS_HERO, getBooleanFromUser("Enter which card is hero (type 'true' or 'false')"));
        data.put(COMBAT_ZONE, getEnumValueFromUser("Enter a combat zone for card by entering a number which is next to the zone name", Zone.class));
        return data;
    }

    private Map<String, Object> getDataForCard() {
        HashMap<String, Object> data = new HashMap<>();
        data.put(NAME, getTextFromUser("Enter a name for card"));
        data.put(DESCRIPTION, getTextFromUser("Enter a description for card"));
        data.put(NATION, getEnumValueFromUser("Enter a nation for card by entering a number which is next to the nation name", Nation.class));
        return data;
    }

    private <T extends Enum<T>> T getEnumValueFromUser(String message, Class<T> enumType) {
        System.out.println(message);
        T[] enumConstants = enumType.getEnumConstants();
        IntStream.range(0, enumConstants.length).forEachOrdered(i -> System.out.printf("%s: %s\n", (i + 1), enumConstants[i]));
        Integer enumNumber = userInput.getIntegerInListFromUser(IntStream.range(1, enumConstants.length + 1).boxed().toList()) - 1;
        return enumConstants[enumNumber];
    }

    private Integer getPositiveNumberFromUser(String message) {
        System.out.println(message);
        Integer number;
        do {
            number = userInput.getIntegerFromUser();
        } while (number < 0);
        return number;
    }

    private Integer getNumberGreaterThanZeroFromUser(String message) {
        System.out.println(message);
        Integer number;
        do {
            number = userInput.getIntegerFromUser();
        } while (number < 1);
        return number;
    }

    private String getTextFromUser(String message) {
        System.out.println(message);
        return userInput.getNotEmptyStringFromUser();
    }

    private Boolean getBooleanFromUser(String message) {
        System.out.println(message);
        Boolean value;
        do {
            value = userInput.getBooleanFromUser();
        } while (value == null);
        return value;
    }
}
