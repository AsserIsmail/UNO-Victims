package UIs;

import base.*;
import base.Cards.AbstractCard;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Stack;


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
        Computer computer = (Computer) this.players[1];


        //Make the board
        this.board = new Board(players, this.getExtention(this.col));
        //Make game
        this.game = new Game(board);

        int i = 0;
        human.deal(board.getDrawDeck());

        computer.deal(board.getDrawDeck());


        drawBoard(human, computer);




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
        //res[1] = new Computer("c1");

        for (int i = 1; i < Integer.parseInt(bots) + 1; i++){
           res[i] = new Computer(("C" + String.valueOf(i)));
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



    private void drawBoard(Human human, Computer computer){

        y.getChildren().clear();

        for (int j = 0; j < human.getHand().size();j++) {

            ImageView humanHand1 = new ImageView();
            humanHand1.setImage(new Image(human.getHand().get(j).getFrontSrc()));


            if (human.getHand().get(j).isPlayable(board.getPlayedCard())) {
                Button playCardButton = new Button();
                playCardButton.setGraphic(humanHand1);
                 //in order to reference the index value later
                int finalJ = j;
                playCardButton.setOnAction(e -> {
                    int index = finalJ;

                    board.setPlayedCard(human.playCard(human.getHand().get(finalJ), board.getPlayedCard()));
                    computer.setAvailableCards(board.getPlayedCard());
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    board.setPlayedCard(computer.playRandom());
                    drawBoard(human, computer);

                });
                y.getChildren().add(playCardButton);

                StackPane.setAlignment(playCardButton, Pos.BOTTOM_CENTER);
                y.getChildren().get(j).setTranslateX(131*j-131*3);
                y.getChildren().get(j).setTranslateY(-20);


            }else{
                y.getChildren().add(humanHand1);
                StackPane.setAlignment(humanHand1, Pos.BOTTOM_CENTER);
                y.getChildren().get(j).setTranslateX(131*j-131*3);

            }


        }
        for (int i1 = 0; i1 < computer.getHand().size(); i1++){ //change with computer hand size
            ImageView computerHand = new ImageView();
            computerHand.setImage(new Image("card_back.png"));
            y.getChildren().add(computerHand);
            StackPane.setAlignment(computerHand, Pos.TOP_CENTER);
            y.getChildren().get(i1+human.getHand().size()).setTranslateX(131*(i1)-131*3);
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
        Button drawDeckButton = new Button();
        drawDeckButton.setGraphic(deck);

        drawDeckButton.setOnAction(e -> {
            if (human.getHand().size() < 10){
                human.draw(board.getDrawDeck());
                drawBoard(human, computer);
            }



        });
        y.getChildren().add(drawDeckButton);
        StackPane.setAlignment(drawDeckButton, Pos.BOTTOM_RIGHT);

        //Show the score
        Label score = new Label();
        score.setText("Score: " + String.valueOf(this.board.getPlayer(0).getScore()));
        score.setFont(new Font(32));
        y.getChildren().add(score);
        StackPane.setAlignment(score, Pos.TOP_LEFT);




    }

}


