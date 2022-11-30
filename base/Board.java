package base;

import base.DCLL.DCL;

import java.util.Collections;
import java.util.Stack;
import java.util.Timer;

/**
 * Board Class - Represents the UNO board.
 * Contains the deck, discard pile, and players.
 */
public class Board {
    private Stack<Card> drawDeck; // the deck of cards

    private Stack<Card> discardDeck; // the discard pile

    private Card playedCard; // the card that is currently on the board

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
    public Board(Player[] allPlayers) {
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
        Collections.shuffle(this.drawDeck);
        this.playedCard = this.drawDeck.pop();
        this.discardDeck.push(this.playedCard);
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
    public Stack<Card> getDrawDeck() {
        return this.drawDeck;
    }

    /**
     * Returns the discard deck.
     * @return  the discard deck
     */
    public Stack<Card> getDiscardDeck() {
        return this.discardDeck;
    }

    /**
     * Returns the played card.
     * @return  the played card
     */
    public Card getPlayedCard() {
        return this.playedCard;
    }

    /**
     * Returns the direction of play.
     * @return  the direction of play
     */
    public int getDirection() {
        return this.direction;
    }

    /**
     * Sets the direction of the game.
     */
    public void setDirection(int r) {
        this.direction = r;
    }

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

    /*
    Change the current colour
     */
    public void setCurrCol(String colour){
        this.currentCol = colour;
    }

}
