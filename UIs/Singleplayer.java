package UIs;

import base.*;
import base.Cards.AbstractCard;
import base.Cards.Card;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
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


    public Singleplayer(String col, String bot){
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
        Scene scene = new Scene(y, 1500, 700);
        ImageView background = new ImageView();
        background.setImage(new Image("UIs/UNO_Logo.png"));
        BackgroundImage bImg = new BackgroundImage(background.getImage(),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        y.setBackground(bGround);
        this.setScene(scene);
        this.show();
    }


    /*
    Creates the players.
     */
    private Player[] getNumPlayers(String bots, String col){

        Player[] res = new Player[2];
        Human h = Human.getH();
        Computer c = Computer.getC();
        res[0] = h;
        res[1] = c;

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
        if (human.getHand().size() == 0 || computer.getHand().size() == 0 || human.getScore() >= 2000
        ){
            game.endGame();

            if (human.getHand().size() == 0 || human.getScore() >= 2000){
                System.out.println("Congratulations You Won!");
                Alert won = new Alert(Alert.AlertType.INFORMATION);
                won.setContentText("Congratulations You Won!");
                won.show();
            }else{
                System.out.println("Unfortunately The Computer Won :(");
                Alert won = new Alert(Alert.AlertType.INFORMATION);
                won.setContentText("Unfortunately The Computer Won :(");
                won.show();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.exit(0);

        }else{
            y.getChildren().clear();

            for (int j = 0; j < human.getHand().size();j++) {

                ImageView humanHand1 = new ImageView();
                System.out.println(human.getHand().get(j).getFrontSrc());
                humanHand1.setImage(new Image(human.getHand().get(j).getFrontSrc()));



                if (human.getHand().get(j).isPlayable(board.getPlayedCard()) || board.getCurrentCol().equals(human.getHand().get(j).getColour())) {
                    Button playCardButton = new Button();
                    playCardButton.setGraphic(humanHand1);

                    int finalJ = j; //in order to reference the index value later
                    playCardButton.setOnAction(e -> {
                        int index = finalJ;

                        game.executeCard(human.getHand().get(finalJ), human);
                        human.playCard(human.getHand().get(finalJ),board.getPlayedCard());
                        human.setAvailableCards(board.getPlayedCard(), board.getCurrentCol());
                        computer.setAvailableCards(board.getPlayedCard(), board.getCurrentCol());
                        if (computer.getACards().size() > 0)game.executeCard(computer.playRandom(), computer);
                        else computer.draw(this.board.getDrawDeck());
                        if (computer.getHand().size() == 1) {
                            Alert aUno = new Alert(Alert.AlertType.INFORMATION);
                            aUno.setContentText("Computer called UNO!");
                            aUno.show();
                        }
                        drawBoard(human, computer);

                    });
                    y.getChildren().add(playCardButton);

                    StackPane.setAlignment(playCardButton, Pos.BOTTOM_LEFT);
                    y.getChildren().get(j).setTranslateX(98*j);
                    y.getChildren().get(j).setTranslateY(-20);
                    y.getChildren().get(j).setScaleX(0.75);
                    y.getChildren().get(j).setScaleY(0.75);


                }else{
                    y.getChildren().add(humanHand1);
                    StackPane.setAlignment(humanHand1, Pos.BOTTOM_LEFT);
                    y.getChildren().get(j).setScaleX(0.75);
                    y.getChildren().get(j).setScaleY(0.75);
                    y.getChildren().get(j).setTranslateX(98*j);

                }


            }
            for (int i1 = 0; i1 < computer.getHand().size(); i1++){ //change with computer hand size
                ImageView computerHand = new ImageView();
                computerHand.setImage(new Image("card_back.png"));
                y.getChildren().add(computerHand);
                StackPane.setAlignment(computerHand, Pos.TOP_CENTER);
                y.getChildren().get(i1+human.getHand().size()).setScaleX(0.75);
                y.getChildren().get(i1+human.getHand().size()).setScaleY(0.75);
                y.getChildren().get(i1+human.getHand().size()).setTranslateX(98*(i1)-98*3);
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
                human.setAvailableCards(this.board.getPlayedCard(), this.board.getCurrentCol());
                if (human.getHand().size()==14){
                    Stack<AbstractCard> s = new Stack<>();
                    String colour = "wild";
                    for (String symbol : Card.wilds) {
                        s.push(new Card(colour, Card.wilds.get(1)));

                    }
                    human.draw(s);
                }else if(human.getHand().size() < 14){
                    human.draw(board.getDrawDeck());


                }
                drawBoard(human, computer);
                computer.setAvailableCards(board.getPlayedCard(), board.getCurrentCol());

                if (computer.getACards().size() > 0)game.executeCard(computer.playRandom(), computer);
                else computer.draw(this.board.getDrawDeck());
                drawBoard(human, computer);
                if (computer.getHand().size() == 1) {
                    Alert aUno = new Alert(Alert.AlertType.INFORMATION);
                    aUno.setContentText("Computer called UNO!");
                    aUno.show();
                }



            });

            y.getChildren().add(drawDeckButton);
            StackPane.setAlignment(drawDeckButton, Pos.CENTER_LEFT);
            y.getChildren().get(y.getChildren().size()-1).setTranslateX(450);

            //Show the score
            Label score = new Label();
            score.setText("Score: " + String.valueOf(this.board.getPlayer(0).getScore()));
            score.setFont(new Font(32));
            y.getChildren().add(score);
            StackPane.setAlignment(score, Pos.CENTER_LEFT);
            y.getChildren().get(y.getChildren().size()-1).setTranslateX(30);


            Button callUNOkButton = new Button();
            callUNOkButton.setText("CALL UNO");

            callUNOkButton.setOnAction(e -> {
                if (human.getHand().size() == 1) {
                    game.callUno(human);
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Human called UNO!");
                    a.show();
                }
                else {
                    human.draw(board.getDrawDeck());
                    human.draw(board.getDrawDeck());
                    this.drawBoard(human, computer);
                }
            });
            y.getChildren().add(callUNOkButton);
            StackPane.setAlignment(callUNOkButton, Pos.BOTTOM_RIGHT);
            y.getChildren().get(y.getChildren().size()-1).setTranslateX(-20);

        }


    }
}


