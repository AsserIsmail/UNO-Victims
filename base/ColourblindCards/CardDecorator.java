package base.ColourblindCards;

import base.Cards.AbstractCard;

/*
Card decorator Class
 */
public abstract class CardDecorator implements AbstractCard {

    /*
    Holds the card which will be then decorated
     */
    private AbstractCard card;

    /*
    Colourblind mode.
     */
    public String filter;

    /*
    Get the source of the front image of the card
     */
    public String getFrontSrc() {throw new UnsupportedOperationException();}

    /*
    Set the source of the front image of the card
     */
    public void setFrontSrc(String src){throw new UnsupportedOperationException();}

    /*
    Get the source of the back image of the card
     */
    public String getBackSrc(){throw new UnsupportedOperationException();}

    /*
    Set the source of the back image of the card
     */
    public void setBackSrc(String src){throw new UnsupportedOperationException();}

}
