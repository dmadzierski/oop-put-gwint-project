package com.gwint.card.special;

import com.gwint.card.core.Actionable;
import com.gwint.card.core.Card;
import com.gwint.card.core.Nation;

public abstract class SpecialCard extends Card implements Actionable {
  public SpecialCard(String name, String description, Nation nation) {
    super(name, description, nation);
  }
}
