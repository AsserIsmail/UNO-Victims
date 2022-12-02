package base;
import java. util. *;
/* The Player Class. Keeps track of information associated with a player*/

import java.util.ArrayList;

public class Player {
    private String name; // name of player

    private int score; // current score of player

    private ArrayList<Card> hand = new ArrayList<>(); // current cards in the players hand

    private ArrayList<Card> availableCards = new ArrayList<>(); // current cards that are able to be played taken from players hand

    private boolean isReady = false; // represents if the player has the readied up status in the lobby

    private boolean isUno = false; // represents when a player is able to say uno i.e. only has 1 card left in their hand

    private String colourBlind; // the form of colourblindness that this player has

    /**
     * Constructor for a new Uno Player with their entered name and form of colourblindness
     * @param playerName    name
     * @param cB    colourBlind
     */

    public Player(String playerName, String cB){
        this.name = playerName;
        this.colourBlind = cB;
        this.score = 0;
    }

    // adds the topmost card from the deck to the players hand
    public void draw(Stack<Card> deck){
        hand.add(deck.pop());
    }

    // returns true if the selected card from the players hand is a playable card, false otherwise
    public boolean play(Card selectedCard){
        if(availableCards.contains(selectedCard)){
            hand.remove(selectedCard);
            return true;
        }
        return false;
    }

    // set isUno to true
    public void uno(){
        this.isUno = true;
    }

    // set isReady to true
    public void setReady(){
        this.isReady = true;
    }

    // return name of player
    public String getName(){
        return this.name;
    }

    // return colourblind variant
    public String getCB(){
        return this.colourBlind;
    }

    // return isUno
    public boolean getUno(){
        return this.isUno;
    }

    // return isReady
    public boolean getReady(){
        return this.isReady;
    }

    // iterates through the hand of the player and adds any playable cards to availableCards by comparing each card to the
    // current card in play
    public void setAvailableCards(Card currentCard){
        for(Card c:hand){
            if(c.isPlayable(currentCard) /* || c.coulour.equals(board.currColour))*/) this.availableCards.add(c);
        }
    }

    // returns availableCards
    public ArrayList<Card> getACards(){
        return this.availableCards;
    }

    /*
    *Adds score to the player
     */
    public void giveScore(int s) {
        this.score += s;
    }

    /*
     *returns the score of this player
     */
    public int getScore() {return this.score;}

    /*
    *returns the hand of the current player
     */
    public ArrayList<Card> getHand() {return this.hand;}
}

