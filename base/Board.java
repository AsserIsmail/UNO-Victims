package base;

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

    private Player currentPlayer; // the current player

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
        this.currentPlayer = this.players[0];
        this.discardDeck = new Stack<>();
        this.direction = 1;
        this.turn = 0;
        this.timeLimit = new Timer();
        this.isUno = false;
        this.drawDeck = new Stack<>();
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
        return this.currentPlayer;
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
     * Returns the number of turns that have been played.
     * @return  the number of turns that have been played
     */
    public int getTurn() {
        return this.turn;
    }

    /**
     * Returns the time limit for the players to play their turn.
     * @return  the time limit for the players to play their turn
     */
    public Timer getTimeLimit() {
        return this.timeLimit;
    }

    /**
     * Returns if the current player has said uno.
     * @return  if the current player has said uno
     */
    public boolean getIsUno() {
        return this.isUno;
    }

    /**
     * Sets the current player.
     * @param player    the player to set as the current player
     */
    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }


}
