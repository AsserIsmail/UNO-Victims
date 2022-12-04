package base.ColourblindCards;

import base.Cards.Card;

public class SGCard extends CardDecorator{


    /*
    Holds the card which will be then decorated
    */
    private Card card;

    /*
    Colourblind mode.
     */
    public String filter;



    public SGCard(Card card){
        this.card = card;
        this.filter = "SG";
    }


    /*
    Get the source of the front image of the card
     */
    public String getFrontSrc() {return card.getFrontSrc() + filter;}

    /*
    Get the source of the back image of the card
     */
    public String getBackSrc(){return card.getBackSrc() + filter;}


    /*
    Checks to see if a card is playable, given a previous card.
     */
    public boolean isPlayable(Card c){return this.card.isPlayable(c);}


    /*
    Equals method
     */
    @Override
    public boolean equals(Object o){return this.card.equals(o);}


}
