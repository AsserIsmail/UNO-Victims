package UIs;

import base.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Singleplayer extends Stage {

    StackPane y = new StackPane(); // Stores all widgets

    private String col; // Stores the colour blind

    private String bot; // Stores the number of bots

    private Player[] players; // Stores the players

    private Board board; // Stores the state of the board

    private Game game; // Stores the state of the game


    Singleplayer(String col, String bot){
        // Set the private attributes
        this.col = col;
        this.bot = bot;
        //Make the player
        this.players = getNumPlayers(bot, col);
        //Make the board
        this.board = new Board(players);
        //Make game
        this.game = new Game(board);


        //Make the back of the deck
        ImageView deck = new ImageView();
        deck.setImage(new Image("./Card variations/Normal/card_back.png"));
        y.getChildren().add(deck);
        StackPane.setAlignment(deck, Pos.BOTTOM_RIGHT);

        //Show everything
        this.setTitle("Single player");
        this.setScene(new Scene(y, 1500, 700));
        this.show();
    }

    private Player[] getNumPlayers(String bots, String col){

        Player[] res = new Player[Integer.parseInt(bots) + 1];

        res[0] = new Human("p1", col);

        for (int i = 1; i < Integer.parseInt(bots); i++){
            res[i] = new Computer("C" + i);
        }

        return res;
    }

}


