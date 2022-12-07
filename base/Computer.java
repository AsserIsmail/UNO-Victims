package base;

import base.Cards.AbstractCard;
import base.Cards.Card;

import java.util.Optional;
import java.util.Random;

public class Computer extends Player{
    private static Computer c;
    /**
     * Constructor for a new Uno Bot
     *
     * @param playerName name
     */
    private Computer(String playerName) {
        super(playerName);
    }

    /**
     * Precondition: this.getACards >= 1 i.e at least 1 playable card
     * returns a random card from the computers playable cards
     * @return a card
     */
    public AbstractCard playRandom(){
        Random rand = new Random();
        AbstractCard randomC = this.getACards().get(rand.nextInt(this.getACards().size()));
        this.getHand().remove(randomC);
        return randomC;
    }
    public static Computer getC(){
        if(c==null){
            c = new Computer("c1");
        }
        return c;
    }

}
