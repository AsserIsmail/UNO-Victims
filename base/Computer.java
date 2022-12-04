package base;

import java.util.Optional;
import java.util.Random;

public class Computer extends Player{
    /**
     * Constructor for a new Uno Player with their entered name and form of colourblindness
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
    public Card playRandom(){
        Random rand = new Random();
        Card randomC = this.getACards().get(rand.nextInt(this.getACards().size()));
        this.getHand().remove(randomC);
        return randomC;
    }

}
