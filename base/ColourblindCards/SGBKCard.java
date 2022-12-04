package base.ColourblindCards;

import base.Cards.AbstractCard;

public class SGBKCard extends CardDecorator{


    /*
    Holds the card which will be then decorated
    */
    private AbstractCard card;

    /*
    Colourblind mode.
     */
    public String filter;



    public SGBKCard(AbstractCard card){
        this.card = card;
        this.filter = "SG-BK";
    }


    /*
    Get the source of the front image of the card
     */
    public String getFrontSrc() {return card.getFrontSrc() + filter;}

    /*
    Set the source of the front image of the card
     */
    public void setFrontSrc(String src){this.card.setFrontSrc(src);}

    /*
    Get the source of the back image of the card
     */
    public String getBackSrc(){return card.getBackSrc() + filter;}

    /*
    Set the source of the back image of the card
     */
    public void setBackSrc(String src){this.setBackSrc(src);}


}
