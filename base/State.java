package base;

import base.Cards.Card;

public interface State {
    public void executeCard(Card c, Player p);
}
