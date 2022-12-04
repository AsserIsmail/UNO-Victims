package base.ColourblindCards;

import base.Cards.AbstractCard;
import base.Cards.Card;

/*
Card decorator Class
 */
public abstract class CardDecorator implements AbstractCard {

    /*
    Holds the card which will be then decorated
     */
    public AbstractCard card;

    public CardDecorator(AbstractCard c){
        this.card = c;
    }

    /*
    Get the source of the front image of the card
     */
    public String getFrontSrc() {throw new UnsupportedOperationException();}

    /*
    Get the source of the back image of the card
     */
    public String getBackSrc(){throw new UnsupportedOperationException();}

    /*
    Checks to see if a card is playable, given a previous card.
     */
    public boolean isPlayable(Card c){throw new UnsupportedOperationException();}


    /*
    Equals method
     */
    public boolean equals(Object o){throw new UnsupportedOperationException();}

}
