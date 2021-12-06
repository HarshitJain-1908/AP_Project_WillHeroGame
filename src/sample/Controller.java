package sample;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public void clickOnPlay(ActionEvent e) {
        System.out.println("Let's play");
    }

    @FXML
    private ImageView myHero;
    @FXML
    Button LoadButton, play;
    //Image image = new Image(getClass().getResourceAsStream("HomePage.jpeg"));

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
    public void switchToGameflow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GameFlow.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void playGame(ActionEvent e) throws IOException {
        System.out.println("play game");
        switchToGameflow(e);
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
}

