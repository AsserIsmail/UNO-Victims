import java.awt.*;
import java.util.ArrayList;
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

    public static final List<String> colours = Arrays.asList("blue", "green", "yellow", "red", "black"); // all the possible colours of a card

    public static final List<String> symbols = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+2", "skip", "rev"); // all the possible symbols

    public static final List<String> wilds = Arrays.asList("wild_colour", "+4"); // all the possible wild cards

/*
 * Card constructor.
 */
    public Card(String col, String symbol){

        this.colour = col;
        this.symbol = symbol;

        if (!(col.equals("black"))){

            if (this.symbols.subList(0, 10).contains(symbol)) {
                this.point = 10;

            } else {
                this.point = 20;
            }

        } else {
            this.point = 50;
        }

    }



}
