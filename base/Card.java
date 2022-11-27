package base;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;



/**
 * A class representing an UNO card.
 */
public class Card {

    private String colour; // colour of the card

    private String symbol; // symbol of the card

    private int point; // the amount of points each card has

    private Image front; // an image of the card's face

    private Image back; // an image of the back of the card

    public static final List<String> colours = Arrays.asList("blue", "green", "yellow", "red", "wild"); // all the possible colours of a card

    public static final List<String> symbols = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "picker", "skip", "reverse"); // all the possible symbols

    public static final List<String> wilds = Arrays.asList("color_changer", "pick_four"); // all the possible wild cards

/*
 * base.Card constructor.
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
        String image = col + "_" + symbol + ".png";
        this.front = new ImageIcon(image).getImage();

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
