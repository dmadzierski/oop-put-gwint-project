package com.gwint;

import com.gwint.card.core.Card;
import com.gwint.card.core.Nation;
import com.gwint.card.core.Zone;
import com.gwint.card.special.DummyCard;
import com.gwint.card.special.HornCard;
import com.gwint.card.special.WeakenWeatherCard;
import com.gwint.card.unit.*;

import java.util.HashSet;
import java.util.Set;

public interface ExampleCards {

    HashSet<Card> exampleCards = new HashSet<>(Set.of(
            new DummyCard("Dummy", "When you run out of peasants, decoys also make decent arrow fodder.", Nation.NEUTRAL, 5),
            new HornCard("Commander's Horn", "Plus one to morale, minus three to hearing.", Nation.NEUTRAL, 1),
            new WeakenWeatherCard("Biting Frost", "Best part about frost - bodies of the fallen don't rot so quickly.", Nation.NEUTRAL, 2, Zone.CLOSE),
            new MedicCard("Yennefer of Vengerberg", "Magic is Chaos, Art and Science. It is a curse, a blessing and a progression.", 7, true, Zone.RANGE, Nation.NEUTRAL, 10),
            new MoraleBoostCard("Jaskier", "Dandelion, you're a cynic, a lecher, a whoremonger, a liar - and my best friend.", 2, false, Zone.CLOSE, Nation.NEUTRAL, 2),
            new ScorchCard("Villentretenmerth", "Also calls himself Borkh Three Jackdaws... he's not the best at names.", 7, false, Zone.CLOSE, Nation.NEUTRAL, 10),
            new SpyCard("Mysterious Elf", "You humans have... unusual tastes.", 0, true, Zone.CLOSE, Nation.NEUTRAL, 2),
            new UnitCard("Cirilla Fiona Elen Riannon", "Know when fairy tales cease to be tales? When people start believing in them.", 15, true, Zone.CLOSE, Nation.NEUTRAL))
    );

}
