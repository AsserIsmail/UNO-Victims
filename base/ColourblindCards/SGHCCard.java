package base.ColourblindCards;

import base.Cards.AbstractCard;
import base.Cards.Card;

public class SGHCCard extends CardDecorator{

    /*
    Colourblind mode.
     */
    public String filter;



    public SGHCCard(AbstractCard card){
        super(card);
        this.filter = "SG-HC";
    }


    /*
    Get the source of the front image of the card
     */
    public String getFrontSrc() {

        if (this.card.getFrontSrc().contains("SG-HC")){
            return this.card.getFrontSrc();
        } else if (this.card.getFrontSrc().contains("SG-BK")) {
            return this.card.getFrontSrc().replace("SG-BK", this.filter);
        } else if (this.card.getFrontSrc().contains("SG")) {
            return this.card.getFrontSrc().replace("SG", this.filter);
        } else if (this.card.getFrontSrc().contains("HC")) {
            return this.card.getFrontSrc().replace("HC", this.filter);
        } else {
            String start = card.getFrontSrc();
            int i = start.indexOf(".png");
            String sub = start.substring(0, i);
            return sub +"_"+filter+".png";
        }

    }


    /*
    Get the source of the back image of the card
     */
    public String getBackSrc(){

        if (this.card.getBackSrc().contains("SG-HC")){
            return this.card.getBackSrc();
        } else if (this.card.getBackSrc().contains("SG-BK")) {
            return this.card.getBackSrc().replace("SG-BK", this.filter);
        } else if (this.card.getBackSrc().contains("SG")) {
            return this.card.getBackSrc().replace("SG", this.filter);
        } else if (this.card.getBackSrc().contains("HC")) {
            return this.card.getBackSrc().replace("HC", this.filter);
        } else {
            String start = card.getBackSrc();
            int i = start.indexOf(".png");
            String sub = start.substring(0, i);
            return sub +"_"+filter+".png";
        }

    }


    /*
    Getter for the colour
    */
    public String getColour(){return this.card.getColour();}

    /*
    Getter for the symbol
     */
    public String getSymbol(){return this.card.getSymbol();}


    /*
    Checks to see if a card is playable, given a previous card.
     */
    public boolean isPlayable(AbstractCard c){return this.card.isPlayable(c);}


    /*
    Equals method
     */
    @Override
    public boolean equals(Object o){

        if (o instanceof Card) return this.card.equals(o);
        else if (o instanceof CardDecorator) return this.card.equals(((CardDecorator) o).card);
        else return false;
    }


}
