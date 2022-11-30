package base;

/*
A class representing an uno game
 */

public class Game {

    public Board board; // Stores the current State of the board

    /*
    Constructor for game class
     */
    public Game(Board b){
        this.board = b;
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


    }

    /*
    When a player calls uno
     */
    public void callUno(Player p){
        p.uno();
    }

    /*
    When a player passes their turn
     */
    public void pass(Player p){
        //idk what is going on here
    }

    /*
    Starts the game
     */
    public void startGame(){
        //idk what is going on here
    }

    /*
    Ends the game
     */
    public void endGame(){
        //idk what is going on here
    }

}
