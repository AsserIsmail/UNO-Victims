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
    Set the source of the front image of the card
     */
    public void setFrontSrc(String src);

    /*
    Get the source of the back image of the card
     */
    public String getBackSrc();

    /*
    Set the source of the back image of the card
     */
    public void setBackSrc(String src);
}
