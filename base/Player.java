package base;
import base.Cards.AbstractCard;
import base.Cards.Card;

import java. util. *;
/* The Player Class. Keeps track of information associated with a player*/

import java.util.ArrayList;

public class Player {
    private String name; // name of player

    private int score; // current score of player

    private ArrayList<AbstractCard> hand = new ArrayList<>(); // current cards in the players hand

    private ArrayList<AbstractCard> availableCards = new ArrayList<>(); // current cards that are able to be played taken from players hand

    private boolean isUno = false; // represents when a player is able to say uno i.e. only has 1 card left in their hand



    /**
     * Constructor for a new Uno Player with their entered name
     * @param playerName    name
     */

    public Player(String playerName){
        this.name = playerName;
        this.score = 0;
    }

    /**
     * Removes a card from the deck and adds it to the players hand
     */
    public void draw(Stack<AbstractCard> deck){
        hand.add(deck.pop());
    }

    /**
     * deals 7 cards to a player
     */
    public void deal(Stack<AbstractCard> deck) {
        for (int i = 0; i < 7; i++) {
            draw(deck);
        }
    }

    /**

     * Sets the status of Uno for the player
     */
    public void setUno(){

        this.isUno = true;
    }

    /**

     * Returns true if the player has said uno, false otherwise
     * @return isUno
     */
    public boolean getUno(){
        return this.isUno;
    }
    /*
     * returns the name of the given player
     * @return the players name
     */
    public String getName(){
        return this.name;
    }


    /**
     * iterates through the hand of the player and adds any playable cards to availableCards by comparing each card to the
     * current card in play
     */
    public void setAvailableCards(AbstractCard currentCard){
        for(AbstractCard c:hand){
            if(c.isPlayable(currentCard) /* || c.coulour.equals(board.currColour))*/) this.availableCards.add(c);
        }
    }

    /**
     * returns the players available cards
     * @return an array list of playable cards
     */
    // returns
    public ArrayList<AbstractCard> getACards(){
        return this.availableCards;
    }

    /**
     * Adds score to the player
     */
    public void giveScore(int s) {
        this.score += s;
    }

    /**
     * returns the score of this player
     * @return the score of this player
     */
    public int getScore() {return this.score;}

    /**
     * returns the hand of the current player
     * @return an array list of cards in the players position
     */
    public ArrayList<AbstractCard> getHand() {return this.hand;}
}

