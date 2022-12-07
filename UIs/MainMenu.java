package UIs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.Stage;

import java.util.Objects;

public class MainMenu extends Application {

    Button playButton; // Button to start the game

    ChoiceBox cBots; // Choose the number of bots

    String numBots; // Number of chosen bots

    String colour; // Chosen colour option

    ChoiceBox cColour; // Choose the colourblind mode

    public static void main(String[] args) {
        // ui stuff probably
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        //Create stage
        stage.setTitle("UNO Main Menu");

        //Setup play button
        playButton = new Button();
        playButton.setText("Play Single player");
        playButton.setOnAction(e -> {
            numBots = (String) cBots.getValue();
            colour = (String) cColour.getValue();
            new Singleplayer(colour, numBots);
        });

        //Adding the choice-box for the number of bots
        cBots = new ChoiceBox<String>();
        cBots.setValue("Bots");
        cBots.getItems().add("1");
        cBots.getItems().add("2");
        cBots.getItems().add("3");



        //Adding the choice-box for the colourblind mode
        cColour = new ChoiceBox<String>();
        cColour.setValue("Colour Blind Mode");
        cColour.getItems().add("Normal");
        cColour.getItems().add("High Contrast");
        cColour.getItems().add("High Contrast Signed");
        cColour.getItems().add("Normal Signed");
        cColour.getItems().add("Black and White Signed");



        //Putting it all together
        StackPane base = new StackPane();
        base.getChildren().add(playButton);
        StackPane.setAlignment(playButton, Pos.CENTER);
        base.getChildren().add(cBots);
        StackPane.setAlignment(cBots, Pos.CENTER);
        base.getChildren().get(1).setTranslateY(30);
        base.getChildren().add(cColour);
        StackPane.setAlignment(cColour, Pos.CENTER);
        base.getChildren().get(2).setTranslateY(60);

        //Making the scene
        Scene scene = new Scene(base, 350, 350);
        ImageView background = new ImageView();
        background.setImage(new Image("UIs/UNO_Logo.png"));
        BackgroundImage bImg = new BackgroundImage(background.getImage(),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        base.setBackground(bGround);

        Button rules = new Button();
        Alert a = new Alert(Alert.AlertType.NONE);


        EventHandler<ActionEvent> uno_victim_rules = new
                EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {
                        // set alert type
                        a.setAlertType(Alert.AlertType.INFORMATION);
                        a.setTitle("UNO VICTIM RULES");

                        // set content text
                        a.setContentText("RULES:\n" +
                                "\n" +
                                "This is a remix of UNO in which you are playing against the bots and your own cards. " +
                                "Any plus 2, plus 4 will add cards to your own hand and any colour altering card allows " +
                                "your opponent to select the colour. It's a race versus your own luck with \n" +
                                "all the thrill of regular UNO. Are you ready to be a Victim to the game?\n");

                        // show the dialog
                        a.show();
                    }
                };
        rules.setOnAction(uno_victim_rules);
        rules.setText("Rules");
        base.getChildren().add(rules);
        StackPane.setAlignment(base, Pos.CENTER);
        base.getChildren().get(3).setTranslateY(90);




        stage.setScene(scene);
        stage.show();
    }
}
