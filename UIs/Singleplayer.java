package UIs;

import base.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Arrays;
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
        Human human = (Human) this.players[0];


        //Make the board
        this.board = new Board(players, this.getExtention(this.col));
        //Make game
        this.game = new Game(board);

        int i = 0;
        while (i < 7){
            human.draw(board.getDrawDeck());
            i++;
        }









        for (int j = 0; j < human.getHand().size();j++) {

            ImageView humanHand1 = new ImageView();
            if (human.getHand().get(j).isPlayable(board.getPlayedCard())) {
                humanHand1.setImage(new Image(human.getHand().get(j).getFrontSrc()));
                y.getChildren().add(humanHand1);
                StackPane.setAlignment(humanHand1, Pos.BOTTOM_LEFT);
                y.getChildren().get(j).setTranslateY(-20);
                y.getChildren().get(j).setTranslateX(131 * j);




            } else {
                humanHand1.setImage(new Image(human.getHand().get(j).getFrontSrc()));
                y.getChildren().add(humanHand1);
                StackPane.setAlignment(humanHand1, Pos.BOTTOM_LEFT);
                y.getChildren().get(j).setTranslateX(131*j);

            }
            // Button playCardButton = new Button();
            //playCardButton.setGraphic(humanHand1);
            //int finalJ = j;
            //playCardButton.setOnAction(e -> {
            //    human.playCard(human.getHand().get(finalJ));
            //});
            //y.getChildren().add(playCardButton);
            //StackPane.setAlignment(playCardButton,Pos.TOP_RIGHT);
        }


        for (int i1 = human.getHand().size(); i1 < 7+human.getHand().size(); i1++){
            ImageView computerHand = new ImageView();
            computerHand.setImage(new Image("card_back.png"));
            y.getChildren().add(computerHand);
            StackPane.setAlignment(computerHand, Pos.TOP_CENTER);
            y.getChildren().get(i1).setTranslateX(131*(i1-7)-131*3);


        }
        ImageView currentCard = new ImageView();
        currentCard.setImage(new Image(board.getPlayedCard().getFrontSrc()));
        y.getChildren().add(currentCard);
        StackPane.setAlignment(currentCard, Pos.CENTER);






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


