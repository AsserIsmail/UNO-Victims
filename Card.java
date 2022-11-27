import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Card {

    private String colour;

    private String symbol;

    private int point;

    private Image front;

    private Image back;

    public static final List<String> colours = Arrays.asList("blue", "green", "yellow", "red", "black");

    public static final List<String> symbols = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+2", "skip", "rev");

    public static final List<String> wilds = Arrays.asList("wild_colour", "+4");


    public Card(String col, String symbol){

        this.colour = col;
        this.symbol = symbol;

        if (!(col.equals("black"))){

            if (!(col.equals("+2"))) {


            }

        }

    }



}
