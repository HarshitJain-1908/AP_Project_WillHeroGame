package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Main extends Application implements Initializable {



    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            stage.setTitle("Will Hero");
            //Group root= new Group();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            Image icon = new Image("Icon.jpeg");
            stage.getIcons().add(icon);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button newgamebutton, loadgamebutton, exitbutton, highscorebutton, playbutton, pausebutton;

    private ImageView myHero;
    private ImageView myBoss;
    private ImageView mycoin;
    private ImageView myGorc;
    private ImageView myRorc;
    private ImageView tnt;



    public void clickOnLoad(ActionEvent e) throws IOException {
        switchToHomepage(e);
    }

    public void switchToHomepage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void playGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GamePage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showPauseMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void startNewGame(ActionEvent e) throws IOException {
        System.out.println("Game started");
        playGame(e);
    }
    public void play(ActionEvent e){
        System.out.println("Play Game");
    }
    public void pauseGame(ActionEvent e) throws IOException {
        System.out.println("Game paused");
        showPauseMenu(e);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(myHero);
        translate.setDuration(Duration.millis(500));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        //translate.setByX(500);
        translate.setByY(100);
        translate.setAutoReverse(true);
        translate.play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
