package UIs;

import base.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.util.concurrent.Callable;


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
        this.board = new Board(players, this.getExtention(this.col));
        //Make game
        this.game = new Game(board);


        //Place the discard deck
        ImageView discardDeck = new ImageView();
        discardDeck.setImage(new Image(this.board.getPlayedCard().getFrontSrc()));
        y.getChildren().add(discardDeck);
        StackPane.setAlignment(discardDeck, Pos.CENTER);


        //Make the back of the deck
        ImageView deck = new ImageView();
        deck.setImage(new Image("./Card variations/Normal/card_back.png"));
        y.getChildren().add(deck);
        StackPane.setAlignment(deck, Pos.BOTTOM_RIGHT);

        //Show the score
        Label score = new Label();
        score.setText("Score: " + String.valueOf(this.board.getPlayer(0).getScore()));
        score.setFont(new Font(32));
        y.getChildren().add(score);
        StackPane.setAlignment(score, Pos.TOP_LEFT);

        //Show everything
        this.setTitle("Single player");
        this.setScene(new Scene(y, 1500, 700));
        this.show();
    }


    /*
    Creates the players.
     */
    private Player[] getNumPlayers(String bots, String col){

        Player[] res = new Player[Integer.parseInt(bots) + 1];

        res[0] = new Human("p1", col);

        for (int i = 1; i < Integer.parseInt(bots); i++){
            res[i] = new Computer("C" + i);
        }

        return res;
    }

    /*
    Returns the extension for the colourblind option
     */
    private String getExtention(String mode){
        if (mode.equals("High Contrast")) return "HC";
        else if (mode.equals("Normal")) return "";
        else if (mode.equals("High Contrast Signed")) return "SG-HC";
        else if (mode.equals("Normal Signed")) return "SG";
        else if (mode.equals("Black and White Signed")) return "SG-BK";
        else return "";
    }

}


