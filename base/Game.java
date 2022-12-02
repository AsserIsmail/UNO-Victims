package base;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
/*
A class representing an uno game
 */

public class Game {

    public Board board; // Stores the current State of the board

    public String currColour; // Current colour of the game

    public Card currCard; // Current card on the board

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

    /*
    Executes the current card
     */
    public void executeCard(Card c){
        /*
        if card is +2: then add 2 cards to the next player and skip round
        if card is +4: then choose a colour and add 4 to next player and skip round
        if card is wild: just change the colour
        if card is skip: just skip the next player
        if card is reverse: next player is previous player and the order reverses
         */

        if (c.getSymbol().equals("picker")) {
            // Go to the next player, draw to cards, go to the next player again.
            this.board.getCurrentPlayer().giveScore(c.getPoint());
            this.board.goToNextPlayer();
            this.board.getCurrentPlayer().draw(this.board.getDrawDeck());
            this.board.getCurrentPlayer().draw(this.board.getDrawDeck());
            this.board.goToNextPlayer();
        } else if (c.getSymbol().equals("skip")) {
            // Skip the first player
            this.board.getCurrentPlayer().giveScore(c.getPoint());
            this.board.goToNextPlayer();
            this.board.goToNextPlayer();
        } else if (c.getSymbol().equals("reverse")) {
            // Change the direction in board and goes to the next player
            this.board.getCurrentPlayer().giveScore(c.getPoint());
            this.board.changeDirection();
            this.board.goToNextPlayer();
        } else if (c.getSymbol().equals("color_changer")) {
            // Print options
            this.board.getCurrentPlayer().giveScore(c.getPoint());
            System.out.println("Enter colour number:");
            System.out.println("Blue -> 1");
            System.out.println("Red -> 2");
            System.out.println("Yellow -> 3");
            System.out.println("Green -> 4");

            // Digest choice
            Scanner newCol = new Scanner(System.in);
            int choice = newCol.nextInt();
            if (choice == 1) this.currColour = "blue";
            else if (choice == 2) this.currColour = "red";
            else if (choice == 3) this.currColour = "yellow";
            else if (choice == 4) this.currColour = "green";

            // Change the current colour info in other classes
            this.board.setCurrCol(this.currColour);
            this.board.goToNextPlayer();

        } else if (c.getSymbol().equals("pick_four")) {
            // Print options
            this.board.getCurrentPlayer().giveScore(c.getPoint());
            System.out.println("Enter colour number:");
            System.out.println("Blue -> 1");
            System.out.println("Red -> 2");
            System.out.println("Yellow -> 3");
            System.out.println("Green -> 4");

            // Digest choice
            Scanner newCol = new Scanner(System.in);
            int choice = newCol.nextInt();
            if (choice == 1) this.currColour = "blue";
            else if (choice == 2) this.currColour = "red";
            else if (choice == 3) this.currColour = "yellow";
            else if (choice == 4) this.currColour = "green";

            // Change the current colour info in other classes
            this.board.setCurrCol(this.currColour);
            this.board.goToNextPlayer();

            // Pick the extra 4 cards.
            this.board.getCurrentPlayer().draw(this.board.getDrawDeck());
            this.board.getCurrentPlayer().draw(this.board.getDrawDeck());
            this.board.getCurrentPlayer().draw(this.board.getDrawDeck());
            this.board.getCurrentPlayer().draw(this.board.getDrawDeck());

        } else {
            this.board.getCurrentPlayer().giveScore(c.getPoint());
            this.board.goToNextPlayer();
        }
    }

    /*
    When a player calls uno
     */
    public void callUno(Player p){
        p.uno();
    }

    /*
    Starts the game
     */
    public void startGame(){
        this.gameOn = true;
        for(Player p: this.board.getPlayers())
            for(int i = 0;i<7;i++){
                p.draw(board.getDrawDeck());
            }
        // this.play();
    }

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

}
