package UIs;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

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
        base.getChildren().add(cBots);
        StackPane.setAlignment(cBots, Pos.CENTER_RIGHT);
        base.getChildren().add(cColour);
        StackPane.setAlignment(cColour, Pos.BOTTOM_CENTER);

        //Making the scene
        Scene scene = new Scene(base, 242, 100);
        stage.setScene(scene);
        stage.show();
    }
}
