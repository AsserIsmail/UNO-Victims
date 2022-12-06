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

    private String colourBlind; // Stores the colour blind

    private Integer bots; // Stores the number of bots


    Singleplayer(String col, String bot){
        //Set title
        this.setTitle("Single player");

        //Make the player
        Player[] players = getNumPlayers(bot, col);

        //Make the board
        Board board = new Board(players);

        //Make game
        Game game = new Game(board);


        //Make the back of the deck
        ImageView deck = new ImageView();
        deck.setImage(new Image("./Card variations/Normal/card_back.png"));
        y.getChildren().add(deck);
        StackPane.setAlignment(deck, Pos.BOTTOM_RIGHT);

        //Show everything
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


