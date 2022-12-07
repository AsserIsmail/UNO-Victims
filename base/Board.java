package base;

import base.Cards.AbstractCard;
import base.Cards.Card;
import base.ColourblindCards.HCCard;
import base.ColourblindCards.SGBKCard;
import base.ColourblindCards.SGCard;
import base.ColourblindCards.SGHCCard;
import base.DCLL.DCL;

import java.util.Collections;
import java.util.Stack;
import java.util.Timer;

/**
 * Board Class - Represents the UNO board.
 * Contains the deck, discard pile, and players.
 */
public class Board {
    private Stack<AbstractCard> drawDeck; // the deck of cards

    private Stack<AbstractCard> copyDeck; // a copy of the drawDeck

    private Stack<AbstractCard> discardDeck; // the discard pile

    private AbstractCard playedCard; // the card that is currently on the board

    private Player[] players; // the players in the game

    private DCL table; // keeps track of the order of the game and players' turn direction

    private Player currentPlayer; // the current player

    private String currentCol; // Current colour on the board

    private int direction; // the direction of play (1 for clockwise, -1 for counterclockwise)

    private int turn; // the number of turns that have been played

    private int numPlayers; // the number of players in the game

    private Timer timeLimit; // the time limit for the players to play their turn

    private boolean isUno = false; // represents if the current player has said uno


    /**
     * Board constructor.
     * @param allPlayers    the players in the game
     */
    public Board(Player[] allPlayers, String cb) {
        this.numPlayers = allPlayers.length;
        this.players = allPlayers;
        this.discardDeck = new Stack<>();
        this.direction = 1;
        this.turn = 0;
        this.timeLimit = new Timer();
        this.isUno = false;
        this.drawDeck = new Stack<>();
        this.currentCol = null;
        this.table = new DCL(this.numPlayers, allPlayers); // the turn object on the board
        this.currentPlayer = this.table.giveCurr();

        for (String colour : Card.colours) {
            if (colour.equals("wild")) {
                for (String symbol : Card.wilds) {
                    drawDeck.push(new Card(colour, symbol));
                    drawDeck.push(new Card(colour, symbol));
                    drawDeck.push(new Card(colour, symbol));
                    drawDeck.push(new Card(colour, symbol));
                }
            } else {
                for (String symbol : Card.symbols) {
                    drawDeck.push(new Card(colour, symbol));
                    if (!symbol.equals("0")) {
                        drawDeck.push(new Card(colour, symbol));
                    }
                }
            }
        }

        if (!(cb.equals(""))) this.drawDeck = this.wrapper(cb);

        Collections.shuffle(this.drawDeck);
        AbstractCard placeHolder = this.drawDeck.pop();
        while (true) {
            if (placeHolder.getColour().equals("wild")) {
                this.discardDeck.push(placeHolder);
                placeHolder = this.drawDeck.pop();
            } else {
                this.playedCard = placeHolder;
                this.discardDeck.push(this.playedCard);
                break;
            }
        }
        this.copyDeck = (Stack<AbstractCard>) this.drawDeck.clone();
    }

    /*
    Wraps the cards for colourblind.
     */
    private Stack<AbstractCard> wrapper(String cb){

        Stack<AbstractCard> newDeck = new Stack<>();

        if (cb.equals("HC")){
            while (this.drawDeck.size() != 0){
                newDeck.push(new HCCard(this.drawDeck.pop()));
            }
        } else if (cb.equals("SG-HC")) {
            while (this.drawDeck.size() != 0){
                newDeck.push(new SGHCCard(this.drawDeck.pop()));
            }
        } else if (cb.equals("SG")) {
            while (this.drawDeck.size() != 0){
                newDeck.push(new SGCard(this.drawDeck.pop()));
            }
        } else if (cb.equals("SG-BK")) {
            while (this.drawDeck.size() != 0){
                newDeck.push(new SGBKCard(this.drawDeck.pop()));
            }
        }

        return newDeck;

    }

    /**
     * Returns the current player.
     * @return  the current player
     */
    public Player getCurrentPlayer() {
        return this.table.giveCurr();
    }

    /**
     * Returns the next player.
     * @return  the next player
     */
    public Player getNextPlayer() {
        return this.table.getNext(this.direction);
    }


    /**
     * Changes the current player to the next player
     */
    public void goToNextPlayer() {
        this.table.goToNext(this.direction);
    }


    /**
     * Returns the current player's index.
     * @return  the current player's index
     */
    public int getCurrentPlayerIndex() {
        for (int index = 0; index < this.numPlayers; index++) {
            if (this.players[index].equals(this.currentPlayer)) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Returns the number of players in the game.
     * @return  the number of players in the game
     */
    public int getNumPlayers() {
        return this.numPlayers;
    }

    /**
     * Returns the player at the given index.
     * @param index     the index of the player
     * @return          the player at the given index
     */
    public Player getPlayer(int index) {
        return this.players[index];
    }

    /**
     * Returns the player with the given name.
     * @param name      the name of the player
     * @return          the player with the given name
     */
    public Player getPlayer(String name) {
        for (Player player : this.players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    /**
     * Returns the draw deck.
     * @return  the draw deck
     */
    public Stack<AbstractCard> getDrawDeck() {
        return this.drawDeck;
    }

    /**
     * Returns the discard deck.
     * @return  the discard deck
     */
    public Stack<AbstractCard> getDiscardDeck() {
        return this.discardDeck;
    }

    /**
     * Returns the played card.
     * @return  the played card
     */
    public AbstractCard getPlayedCard() {
        return this.playedCard;
    }

    /**
     * Sets the played card.
     */
    public void setPlayedCard(AbstractCard card) {
        this.playedCard = card;
    }

    /**
     * Returns the direction of play.
     * @return  the direction of play
     */
    public int getDirection() {
        return this.direction;
    }

    /**
     * Returns list of players.
     * @return  the list of players
     */
    public Player[] getPlayers(){return this.players;}

    /**
     * changes the direction of the game.
     */
    public void changeDirection() {this.direction = -1 * this.direction;}

    /**
     * Returns the number of turns that have been played.
     * @return  the number of turns that have been played
     */
    public int getTurn() {
        return this.turn;
    }


    /**
     * Increments the round.
     */
    public void addTurn() {
        this.turn++;
    }


    /**
     * Returns the time limit for the players to play their turn.
     * @return  the time limit for the players to play their turn
     */
    public Timer getTimeLimit() {
        return this.timeLimit;
    }
    public void refill(){
        if(this.drawDeck.size() < 4) this.drawDeck = this.copyDeck;
        Collections.shuffle(this.drawDeck);
    }

    /*
    Change the current colour
     */
    public void setCurrCol(String colour){
        this.currentCol = colour;
    }

}
