package base;

import base.Cards.AbstractCard;
import base.Cards.Card;

import java.util.Optional;
import java.util.Random;

public class Computer extends Player{
    /**
     * Constructor for a new Uno Bot
     *
     * @param playerName name
     */
    public Computer(String playerName) {
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

}
