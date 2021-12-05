package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Controller {

    public void clickOnPlay(ActionEvent e) {
        System.out.println("Let's play");
    }

    //@FXML

    //ImageView myImageView;
    @FXML
    Button LoadButton, play;
    //Image image = new Image(getClass().getResourceAsStream("HomePage.jpeg"));

    public void clickOnLoad(ActionEvent e) throws IOException {
        switchToScene2(e);
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void playGame(ActionEvent e){
        System.out.println("play game");
    }
}

