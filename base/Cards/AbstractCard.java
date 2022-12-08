package base.Cards;

/*
Card Interface
 */
public interface AbstractCard {

    /*
    Get the source of the front image of the card
     */
    public String getFrontSrc();

    /*
    Get the source of the back image of the card
     */
    public String getBackSrc();


    /*
    Getter for the colour
    */
    public String getColour();

    /*
    Getter for the symbol
     */
    public String getSymbol();

    public int getPoint();

    /*
    Checks to see if a card is playable, given a previous card.
     */
    public boolean isPlayable(AbstractCard c);

    /*
    Equals method
     */
    public boolean equals(Object o);
}
