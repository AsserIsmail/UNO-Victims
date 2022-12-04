package base.ColourblindCards;

import base.Cards.AbstractCard;

public class SGCard extends CardDecorator{


    /*
    Holds the card which will be then decorated
    */
    private AbstractCard card;

    /*
    Colourblind mode.
     */
    public String filter;



    public SGCard(AbstractCard card){
        this.card = card;
        this.filter = "SG";
    }


    /*
    Get the source of the front image of the card
     */
    public String getFrontSrc() {return card.getFrontSrc();}

    /*
    Set the source of the front image of the card
     */
    public void setFrontSrc(String src){this.card.setFrontSrc(src);}

    /*
    Get the source of the back image of the card
     */
    public String getBackSrc(){return card.getBackSrc();}

    /*
    Set the source of the back image of the card
     */
    public void setBackSrc(String src){this.setBackSrc(src);}


}
