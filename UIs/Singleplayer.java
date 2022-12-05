package UIs;

import base.Board;
import base.Game;
import base.Player;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Singleplayer extends Stage {

    StackPane y = new StackPane(); // Stores all widgets


    Singleplayer(String col, String bot){
        //Set title
        this.setTitle("Single player");

        //Make the back of the deck
        ImageView deck = new ImageView();
        deck.setImage(new Image("./Card variations/Normal/card_back.png"));
        y.getChildren().add(deck);
        y.setAlignment(deck, Pos.CENTER);

        //Show everything
        this.setScene(new Scene(y, 1500, 700));
        this.show();
    }

    private Player[] getNumPlayers(){

        throw new UnsupportedOperationException();

    }

}


