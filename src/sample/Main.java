package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import javax.swing.*;
import java.awt.*;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception{

        stage.setTitle("Will Hero");
        Group root= new Group();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        Image icon=new Image("Icon.jpeg");
        stage.getIcons().add(icon);
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
