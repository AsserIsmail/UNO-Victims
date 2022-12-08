package base;

import base.Cards.AbstractCard;

public interface State {
    public void executeCard(AbstractCard c, Player p);
}
