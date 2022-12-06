package base;
import base.Cards.AbstractCard;
import base.Cards.Card;

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
    public Game(Board b){
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
//    @Override
//    public void executeCard(Card c, Player p) {
//        AbstractCard prevCard = null;
//        if (!this.board.getPlayedCard().getSymbol().equals("replicate")) {
//            prevCard = this.board.getPlayedCard();
//            this.board.getDiscardDeck().push(c);
//        }
//        this.currCard = c;
//        this.currColour = c.getColour();
//        this.board.setPlayedCard(this.currCard);
//        p.giveScore(this.currCard.getPoint());
//
//        if (this.currCard.getSymbol().equals("picker")) {
//            // Go to the next player, draw to cards, go to the next player again. implementation
//            this.board.goToNextPlayer();
//            p.draw(this.board.getDrawDeck());
//            p.draw(this.board.getDrawDeck());
//            this.board.goToNextPlayer();
//        } else if (this.currCard.getSymbol().equals("skip")) {
//            // Skip the first player
//            this.board.goToNextPlayer();
//            this.board.goToNextPlayer();
//        } else if (this.currCard.getSymbol().equals("reverse")) {
//            // Change the direction in board and goes to the next player
//            this.board.changeDirection();
//            this.board.goToNextPlayer();
//        } else if (this.currCard.getSymbol().equals("color_changer")) {
//            // Print options
//            System.out.println("Enter colour number:");
//            System.out.println("Blue -> 1");
//            System.out.println("Red -> 2");
//            System.out.println("Yellow -> 3");
//            System.out.println("Green -> 4");
//
//            // Digest choice
//            Scanner newCol = new Scanner(System.in);
//            int choice = newCol.nextInt();
//            if (choice == 1) this.currColour = "blue";
//            else if (choice == 2) this.currColour = "red";
//            else if (choice == 3) this.currColour = "yellow";
//            else if (choice == 4) this.currColour = "green";
//
//            // Change the current colour info in other classes
//            this.board.setCurrCol(this.currColour);
//            this.board.goToNextPlayer();
//
//        } else if (this.currCard.getSymbol().equals("pick_four")) {
//            // Print options
//            System.out.println("Enter colour number:");
//            System.out.println("Blue -> 1");
//            System.out.println("Red -> 2");
//            System.out.println("Yellow -> 3");
//            System.out.println("Green -> 4");
//
//            // Digest choice
//            Scanner newCol = new Scanner(System.in);
//            int choice = newCol.nextInt();
//            if (choice == 1) this.currColour = "blue";
//            else if (choice == 2) this.currColour = "red";
//            else if (choice == 3) this.currColour = "yellow";
//            else if (choice == 4) this.currColour = "green";
//
//            // Change the current colour info in other classes
//            this.board.setCurrCol(this.currColour);
//            this.board.goToNextPlayer();
//
//            // Pick the extra 4 cards.
//            p.draw(this.board.getDrawDeck());
//            p.draw(this.board.getDrawDeck());
//            p.draw(this.board.getDrawDeck());
//            p.draw(this.board.getDrawDeck());
//
//        }
//        else if (this.currCard.getSymbol().equals("replicate")) {
//            executeCard(prevCard, p);
//
//        } else {
//            this.board.goToNextPlayer();
//        }
//    }

    /**
     * When a player calls uno and has only one card left in their hand
     * @param p is a Player object that has called uno
     */
    public void callUno(Player p){
        if (p.getHand().size() == 1){
            p.setUno();
        }
    }

    /*
    Starts the game
     */
//    public void startGame(){
//        this.gameOn = true;
//        for(Player p: this.board.getPlayers()) p.deal(board.getDrawDeck());
//        // this.play();
//    }

    /**
     * Play the game. Where the game actually happens
     * */


    /**
     * Play the game. Where the game actually happens
     * */
//    public void play(){
//        while(gameOn){
//            this.board.refill();
//            this.board.getCurrentPlayer().setAvailableCards(this.currCard);
//            if(this.board.getCurrentPlayer().getACards().size() == 0) this.board.getCurrentPlayer().draw(this.board.getDrawDeck());
//            else{
//                boolean x = false;
//                while(!x){
//                   // x = this.board.getCurrentPlayer().play(will handle a mouse event here);
//                }
//
//            }
//            if(this.board.getCurrentPlayer().getScore() >= 500 || this.board.getCurrentPlayer().getHand().size() == 0) gameOn = false;
//        }
//
//    }

    /*
    Ends the game
     */
    public void endGame(){
        this.gameOn = false;
    }

    @Override
    public void executeCard(Card c, Player p) {

    }
}
