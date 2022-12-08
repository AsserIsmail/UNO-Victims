package base;
import UIs.Singleplayer;
import base.Cards.AbstractCard;
import base.Cards.Card;
import javafx.scene.control.ChoiceBox;

import java.util.Random;
import java.util.Scanner;
/*
A class representing an uno game
 */

public class Game implements State {

    public Board board; // Stores the current State of the board

    public String currColour; // Current colour of the game

    public AbstractCard currCard; // Current card on the board

    public boolean gameOn;

    /*
    Constructor for game class
     */
    public Game(Board b) {
        this.board = b;
        this.currCard = null;
        this.currColour = null;
        this.gameOn = false;
    }

    /**
     * Executes the current card
     * if card is +2: then add 2 cards to the next player and skip round
     * if card is +4: then choose a colour and add 4 to next player and skip round
     * if card is wild: just change the colour
     * if card is skip: just skip the next player
     * if card is reverse: next player is previous player and the order reverses
     * if card is a number: just play the card
     *
     * @param c is a Card object that has been played
     * @param p is a Player object that has played the card
     */
    @Override
    public void executeCard(AbstractCard c, Player p) {

        System.out.println(p.getName() + " played " + c.getFrontSrc());

        board.setCurrCol(c.getColour());

        AbstractCard prevCard = null;
        if (!this.board.getPlayedCard().getSymbol().equals("replicate")) {
            prevCard = this.board.getPlayedCard();
            this.board.getDiscardDeck().push(c);
        }
        this.currCard = c;
        this.currColour = c.getColour();
        this.board.setPlayedCard(this.currCard);
        p.giveScore(this.currCard.getPoint());

        if (this.currCard.getSymbol().equals("picker")) {
            // Go to the next player, draw to cards, go to the next player again. implementation
            this.board.goToNextPlayer();

            // Pick the extra 2 cards.
            this.board.getCurrentPlayer().draw(this.board.getDrawDeck());
            this.board.getCurrentPlayer().draw(this.board.getDrawDeck());

            this.board.goToNextPlayer();

        } else if (this.currCard.getSymbol().equals("skip")) {
            // Skip the first player
            this.board.goToNextPlayer();
            this.board.goToNextPlayer();

        } else if (this.currCard.getSymbol().equals("reverse")) {
            // Change the direction in board and goes to the next player
            this.board.changeDirection();
            this.board.goToNextPlayer();

        } else if (this.currCard.getSymbol().equals("color_changer")) {
            // Print options
            if (p instanceof Human){
                // Print options
                System.out.println("Enter colour number:");
                System.out.println("Blue -> 1");
                System.out.println("Red -> 2");
                System.out.println("Yellow -> 3");
                System.out.println("Green -> 4");

                // Digest choice
                Scanner newCol = new Scanner(System.in);
                int choice = newCol.nextInt();
                if (choice == 1)      this.board.setCurrCol("blue");
                else if (choice == 2) this.board.setCurrCol("red");
                else if (choice == 3) this.board.setCurrCol("yellow");
                else if (choice == 4) this.board.setCurrCol("green");

            } else {

                Random rand = new Random();
                int cComp = rand.nextInt(4);

                if (cComp == 0) this.board.setCurrCol("blue");
                else if (cComp == 1) this.board.setCurrCol("red");
                else if (cComp == 2) this.board.setCurrCol("yellow");
                else this.board.setCurrCol("green");
                System.out.println("The bot chose: " + this.board.getCurrentCol());
            }

            // Change the current colour info in other classes
            this.board.goToNextPlayer();

        } else if (this.currCard.getSymbol().equals("pick_four")) {

            if (p instanceof Human){
                // Print options
                System.out.println("Enter colour number:");
                System.out.println("Blue -> 1");
                System.out.println("Red -> 2");
                System.out.println("Yellow -> 3");
                System.out.println("Green -> 4");

                // Digest choice
                Scanner newCol = new Scanner(System.in);
                int choice = newCol.nextInt();
                if (choice == 1)      this.board.setCurrCol("blue");
                else if (choice == 2) this.board.setCurrCol("red");
                else if (choice == 3) this.board.setCurrCol("yellow");
                else if (choice == 4) this.board.setCurrCol("green");

            } else {

                Random rand = new Random();
                int cComp = rand.nextInt(4);

                if (cComp == 0) this.board.setCurrCol("blue");
                else if (cComp == 1) this.board.setCurrCol("red");
                else if (cComp == 2) this.board.setCurrCol("yellow");
                else this.board.setCurrCol("green");
                System.out.println("The bot chose: " + this.board.getCurrentCol());
            }

            System.out.println(this.board.getCurrentCol());

            this.board.goToNextPlayer();

            // Pick the extra 4 cards.
            this.board.getCurrentPlayer().draw(this.board.getDrawDeck());
            this.board.getCurrentPlayer().draw(this.board.getDrawDeck());
            this.board.getCurrentPlayer().draw(this.board.getDrawDeck());
            this.board.getCurrentPlayer().draw(this.board.getDrawDeck());

        } else if (this.currCard.getSymbol().equals("replicate")) {
            executeCard(prevCard, p);

        } else {
            this.board.goToNextPlayer();
        }
    }

    /**
     * When a player calls uno and has only one card left in their hand
     *
     * @param p is a Player object that has called uno
     */
    public void callUno(Player p) {
        if (p.getHand().size() == 1) {
            p.setUno();
        }
    }

    /*
    Ends the game
     */
    public void endGame() {
        this.gameOn = false;

    }

}
