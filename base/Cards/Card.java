package base.Cards;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;



/**
 * A class representing an UNO card.
 */
public class Card implements AbstractCard{

    private String colour; // colour of the card

    private String symbol; // symbol of the card

    private int point; // the amount of points each card has

    private Image front; // an image of the card's face

    private Image back; // an image of the back of the card

    private String front_src; // stores the source of the front image

    private String back_src; // stores the source of the back image

    public static final List<String> colours = Arrays.asList("blue", "green", "yellow", "red", "wild"); // all the possible colours of a card

    public static final List<String> symbols = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "picker", "skip", "reverse"); // all the possible symbols

    public static final List<String> wilds = Arrays.asList("color_changer", "pick_four"); // all the possible wild cards

/*
 * base.Cards.Card constructor.
 */
    public Card(String col, String symbol){

        this.colour = col;
        this.symbol = symbol;

        if (!(col.equals("wild"))){

            if (this.symbols.subList(0, 10).contains(symbol)) {
                this.point = 10;

            } else {
                this.point = 20;
            }

        } else {
            this.point = 50;
        }

        this.back = new ImageIcon("card_back.png").getImage();
        this.back_src = "card_back.png";
        String image = col + "_" + symbol + ".png";
        this.front = new ImageIcon(image).getImage();
        this.front_src = image;

    }


    /*
    Getter for the colour
     */
    public String getColour(){return this.colour;}

    /*
    Getter for the symbol
     */
    public String getSymbol(){return this.symbol;}

    /*
    Getter for card's point value
     */
    public int getPoint(){return this.point;}

    /*
    Getter method for back image
     */
    public String getBack() {
        return this.back_src;
    }

    /*
    Getter function for the front image
     */
    public String getFront() {
        return this.front_src;
    }

    /**
    *Checks if a card is playable based on the colour and the symbol of the given card.
    * @return true if the given card is playable
    * */
    public boolean isPlayable(Card c){
        return this.symbol.equals(c.getSymbol()) || this.colour.equals(c.getColour());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o){
            return true;
        } else if (!(o instanceof Card)) {
            return false;
        } else {
            return ((Card) o).colour.equals(this.colour) && ((Card) o).symbol.equals(this.symbol);
        }
    }
}
