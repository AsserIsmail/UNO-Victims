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
    Checks to see if a card is playable, given a previous card.
     */
    public boolean isPlayable(Card c);

    /*
    Equals method
     */
    public boolean equals(Object o);
}
