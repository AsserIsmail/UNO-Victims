package base.ColourblindCards;

import base.Cards.Card;

public class SGBKCard extends CardDecorator{


    /*
    Holds the card which will be then decorated
    */
    private Card card;

    /*
    Colourblind mode.
     */
    public String filter;



    public SGBKCard(Card card){
        this.card = card;
        this.filter = "SG-BK";
    }


    /*
    Get the source of the front image of the card
     */
    public String getFrontSrc() {

        if (this.card.getFrontSrc().contains("SG-BK")){
            return this.card.getFrontSrc();
        } else if (this.card.getFrontSrc().contains("HC")) {
            return this.card.getFrontSrc().replace("HC", this.filter);
        } else if (this.card.getFrontSrc().contains("SG")) {
            return this.card.getFrontSrc().replace("SG", this.filter);
        } else if (this.card.getFrontSrc().contains("SG-HC")) {
            return this.card.getFrontSrc().replace("SG-HC", this.filter);
        } else return this.card.getFrontSrc() + this.filter;

    }


    /*
    Get the source of the back image of the card
     */
    public String getBackSrc(){

        if (this.card.getBackSrc().contains("SG-BK")){
            return this.card.getBackSrc();
        } else if (this.card.getBackSrc().contains("HC")) {
            return this.card.getBackSrc().replace("HC", this.filter);
        } else if (this.card.getBackSrc().contains("SG")) {
            return this.card.getBackSrc().replace("SG", this.filter);
        } else if (this.card.getBackSrc().contains("SG-HC")) {
            return this.card.getBackSrc().replace("SG-HC", this.filter);
        } else return this.card.getBackSrc() + this.filter;

    }

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
