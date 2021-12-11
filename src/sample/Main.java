package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Main extends Application implements Initializable {

    public static void main(String[] args) {
        launch(args);
        Game g=new Game();

    }
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            stage.setTitle("Will Hero");
            //Group root= new Group();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            Image icon = new Image("Icon.jpeg");
            stage.getIcons().add(icon);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private ImageView  startbutton, playbutton, pausebutton, burst, bomb, island, island3, myhero, myBoss, mycoin, myRorc, myGorc;
    @FXML
    Label score;
    @FXML
    Button newgamebutton, loadgamebutton, highscorebutton, exitbutton, resumebutton, exiticon;
    //AnchorPane root;
    Group gp=new Group();


    int loc=0;
//    public void clickOnLoad(ActionEvent e) throws IOException {
//        switchToHomepage(e);
//    }

//    public void switchToHomepage(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
    public void playGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("heroname.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void entername(KeyEvent e){
       // System.out.println("name entered");
    }
    public void startGame(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GamePage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showPauseMenu(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void startNewGame(ActionEvent e) throws IOException {
        System.out.println("Game started");
        playGame(e);
       //check();
    }
    public void check() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        StackPane pane=(StackPane) root;
        Image icon = new Image("island.png");
        ImageView island2=new ImageView(icon);
        System.out.println("CHECK");
        System.out.println(pane.getChildren());
        //pane.getChildren().add(image);
        System.out.println(pane.getChildren());
        Image icon1=new Image("island.png");
        ImageView i=new ImageView(icon1);
        i.setFitWidth(314);
        i.setFitHeight(260);
        i.setX(0);
        i.setY(0);
        pane.getChildren().add(i);//pane.

        Stage stage=new Stage();
        Scene scene = new Scene(root,879,600);
        stage.setScene(scene);
        stage.show();
    }
    //Parent root;
    ImageView island2;
    TranslateTransition translate2=new TranslateTransition();
    public void switchToGameScreen(MouseEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("gameScene.fxml"));
        Image icon = new Image("island.png");
        island2=new ImageView(icon);
        StackPane pane=(StackPane)root;
        island2.setFitWidth(314);
        island2.setFitHeight(260);
        //island2.setX(1200);
        island2.setTranslateX(120);
        island2.setTranslateY(95);
        pane.getChildren().add(island2);
        //TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(island2);
        translate2.setDuration(Duration.millis(3000));
        translate2.setByY(80);
        translate2.setCycleCount(TranslateTransition.INDEFINITE);
        translate2.setAutoReverse(true);
        translate2.play();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void restart(ActionEvent e){

    }
    public void resume(ActionEvent e){

    }

    public void save(ActionEvent e){

    }
    public void exit(ActionEvent e){

    }
    public void play(MouseEvent e) throws IOException {
        System.out.println("Play Game");
        switchToGameScreen(e);

        //StackPane s=new StackPane();
        //root=new AnchorPane();
//        Parent groot = FXMLLoader.load(getClass().getResource("GameObjectsPresence.fxml"));
//        root= (AnchorPane)(groot);
//        root.getChildren().add(bigisland);
//        root.getChildren().add(myGorc);
//        Scene scene=new Scene(root);
//        Stage stage=new Stage();
//        stage.setScene(scene);
//        stage.show();

    }
    public void pauseGame(MouseEvent e) throws IOException {
        System.out.println("Game paused");
        showPauseMenu(e);
    }
//    public void moving(){
//
//    }
    public void moveforward(MouseEvent e) throws IOException {

        loc++;
        System.out.println("Move");
        TranslateTransition translate = new TranslateTransition();
        TranslateTransition translate1 = new TranslateTransition();
        TranslateTransition translate2 = new TranslateTransition();
        TranslateTransition translate3 = new TranslateTransition();
        TranslateTransition translate4 = new TranslateTransition();
        TranslateTransition translate5 = new TranslateTransition();
        TranslateTransition translate6 = new TranslateTransition();
        TranslateTransition translate7 = new TranslateTransition();
        Image icon = new Image("island.png");
        island2=new ImageView(icon);
        translate.setNode(myhero);
        translate1.setNode(island);
        translate2.setNode(island2);
        //translate3.setNode(move);
        translate4.setNode(score);
        translate5.setNode(island3);
        translate6.setNode(bomb);
        translate7.setNode(burst);
        //score.setText((String)(loc));
        translate.setDuration(Duration.millis(150));
        translate1.setDuration(Duration.millis(300));
        translate2.setDuration(Duration.millis(300));
        translate5.setDuration(Duration.millis(300));
        translate6.setDuration(Duration.millis(300));
        translate3.setDuration(Duration.millis(300));
        translate7.setDuration(Duration.millis(300));
        translate.setByX(50);
        //translate3.setByX(57);
        translate1.setByX(-57);
        translate2.setByX(-57);
        translate5.setByX(-57);
        translate6.setByX(-57);
        translate7.setByX(-57);
        //translate2.setByY(10);
        myhero.setX(myhero.getX() + 1);
        island.setX(-5);
        System.out.println(island+" "+island2);
        island2.setX(-5);
        System.out.println(island.getX()+" "+island2.getX());
        island3.setX(-5);
        bomb.setX(-5);
        burst.setX(-15);
        if (myhero.getX() == 3) {
//            System.out.println("ok" + myhero.getX()+" "+translate.getByX());
//            island.setX(-5);
//            island2.setX(-5);
//            island3.setX(-5);
//            bomb.setX(-5);
//            burst.setX(-15);
            System.out.println("game over");
            translate.setDuration(Duration.millis(800));
            translate.setByY(translate.getToY()+100);
            translate.setAutoReverse(false);
            myhero.setY(-10);
            translate.play();
            //overgame();
//            Label l=new Label();
//            l.setText("GAME OVER");
//            l.setTranslateX(100);
//            root.getChildrenUnmodifiable().add(l);

        }
        if(myhero.getX()==8){
            bomb.setOpacity(0.7);
            translate7.setDuration(Duration.millis(0));
            //translate7.setByX(translate6.getByX());
            translate7.setToX(translate6.getByX());
            System.out.println(translate6.getByX()+" "+bomb.getX());
            burst.setX(bomb.getX());
            translate7.play();
        }
        translate.play();
        translate1.play();
        translate2.play();
        //translate3.play();
        translate4.play();
        translate5.play();
        translate6.play();
        translate7.play();

//        if (myhero.getX() == 3) {
//            System.out.println("Game over");
//            translate.setDuration(Duration.millis(300));
//            translate.setByY(1500);
//            translate.play();
//        }
    }
    public void overgame() throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("overgame.fxml"));
        Stage stage=new Stage();
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(myhero);
        translate.setDuration(Duration.millis(500));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        //translate.setByX(50);
        translate.setByY(100);
        translate.setAutoReverse(true);
        translate.play();
    }

}
