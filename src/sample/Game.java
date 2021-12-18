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

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class Game extends Application implements Initializable, Serializable {


    private static Player hero;
    private LinkedList<GameObjects> gameObjects;
    private LinkedList<Island> island;
    private LinkedList<Orc> orc;
    private LinkedList<Obstacle> obstacles;
    private LinkedList<Treasure> chests;

    private static int highScore;
    private int gid;
    private static long serialVersionUID;

    @FXML
    private ImageView  startbutton, playbutton, pausebutton, burst, bomb, island1, island2, island3, open_chest, c_chest, island4, myhero, myBoss, mycoin, myRorc, gOrc;
    @FXML
    Label score, noOfCoins;
    TranslateTransition translate2=new TranslateTransition();
    @FXML
    Button newgamebutton, loadgamebutton, highscorebutton, exitbutton, resumebutton, exiticon, gameinstr, exitinstr;

    private int loc=0, coins=0;
    private String s="";



    public Game(){

        gameObjects = new LinkedList<>();
        island=new LinkedList<>();
        orc=new LinkedList<>(); //all orcs including boss
        obstacles=new LinkedList<>(); //obstacles
        chests=new LinkedList<>(); //chests
        placeGameObjects();

    }
    private void placeGameObjects(){
        //placing islands - 22 islands in total
        Coordinates s,e;
        int loc = 0;
        for (int i=0;i<20;i++){
            if (loc%2==0){
                s = new Coordinates(loc, 0);
                e = new Coordinates(loc+2, 0);
                Island isd = new Island(i+1, s, e);
                island.add(isd);
            }
            else if (loc%2==1 && loc%9==0){ //3 moving islands
                s = new Coordinates(loc, 0);
                e = new Coordinates(loc+1, 0);
                MovingIsland isd = new MovingIsland(i+1, s, e);
                island.add(isd);
            }
            else{
                s = new Coordinates(loc, 0);
                e = new Coordinates(loc+1, 0);
                Island isd = new Island(i+1, s, e);
                island.add(isd);
            }
            loc += 3;
        }

        Coordinates st1, e1, st2,  e2;
        st1 = new Coordinates(58, 0);
        e1 = new Coordinates(60, 0);
        st2 = new Coordinates(60, 0);
        e2 = new Coordinates(61, 0);
        Island isd1 = new Island(21, st1, e1);
        Island isd2 = new Island(22, st2, e2);
        island.add(isd1);
        island.add(isd2);

        //adding obstacle - TNT
        Coordinates s1, s2;
        s1 = new Coordinates(12, 0);
        s2 = new Coordinates(36, 0);
        Obstacle obst1 = new Obstacle(23, s1);
        obstacles.add(obst1);
        Obstacle obst2 = new Obstacle(24, s2);
        obstacles.add(obst2);

        //adding chests: coin chest at coordinates 6 and 24, weapon chest at coordinates 18, 30 and 42
        int loc_chest = 6;
        for (int i=0;i<2;i++){
            s = new Coordinates(loc_chest, 0);
            CoinChest c_chest = new CoinChest(i+25, s, 50); //ids 25 and 26
            chests.add(c_chest);
            loc_chest += 18; //second coin chest at 24
        }

        loc_chest = 18;
        for (int i=0;i<3;i++){
            String[] arr = {"axe", "rocket", "axe"};
            s = new Coordinates(loc_chest, 0);
            WeaponChest w_chest = new WeaponChest(i+27, s, arr[i]); //ids 27, 28 and 29
            chests.add(w_chest);
            loc_chest += 12;
        }

        //adding Orcs - Green at positions = 3, 7, 9, 13, 15, 19
        int loc_orc = 3;
        for (int i=0;i<6;i++){
            s = new Coordinates(loc_orc, 0);
            GreenOrc orc1 = new GreenOrc(i+30, s, "green", 2, 30, 10);
            orc.add(orc1);
            if (i%2==0){ //i = 0,2,4
                loc+=4;
            }
            else { //i= 1, 3, 5
                loc += 2;
            }
        }

        //loc_orc = 21 at this point
        //adding Orcs - Red at positions = 21, 25, 27, 31, 33, 37
        for (int i=0;i<6;i++){
            s = new Coordinates(loc_orc, 0);
            RedOrc orc1 = new RedOrc(i+36, s, "red", 2, 40, 10);
            orc.add(orc1);
            if (i%2==0){ //i = 0,2,4
                loc+=4;
            }
            else { //i= 1, 3, 5
                loc += 2;
            }
        }

        //adding Boss
        Coordinates s0;
        s0 = new Coordinates(58, 0);
        Boss boss = new Boss(52, s0, "boss", 10, 70, 100);
        orc.add(boss);


        //s.setX();

    }

    public void instantiate_hero(){
        hero=new Player(s,myhero);
        System.out.println(hero+" hero :"+hero.getName());
    }
    public void startNewGame(ActionEvent e) throws IOException {
        System.out.println("Game started");
        playGame(e);
    }
    public void enterScreen(){

    }
    public void playGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("heroname.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void saveGame(){

    }
    public void loadGame(){

    }
    public void pauseGame(MouseEvent event) throws IOException {
        System.out.println("Game paused");
        Parent root = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void resumeGame(){

    }
    public void restartGame(){

    }
    public void useCoins(){

    }
    public void exitGame(){

    }
    public boolean ifHighScore(){
        return true;
    }
    public void updateHighScore(){

    }
    public void viewHighScore(){

    }
    public void upgradeHeroWeapon(){

    }
    public void setHeroWeapon(){

    }
    public void updateHeroLocation(){

    }

    public int getGid() {
        return gid;
    }
    public void serialize()
    {

    }
    public void deserialize(){
    }

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


    public void backGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void entername(KeyEvent e){
        s+=e.getCharacter();
    }
    public void startGame(MouseEvent event) throws IOException {
        // instantiate hero
        instantiate_hero();
        Parent root = FXMLLoader.load(getClass().getResource("GamePage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void aboutGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Instructions.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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

    public void switchToGameScreen(MouseEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("gameScene.fxml"));
        StackPane pane=(StackPane)root;
        Image icon = new Image("island.png");
        island2=new ImageView(icon);
        island2.setFitWidth(314);
        island2.setFitHeight(260);
        island2.setTranslateX(520);
        island2.setTranslateY(95);
        pane.getChildren().add(island2);
        translate2.setNode(island2);
        System.out.println(island2.getTranslateX()+" "+island2.getTranslateY()+" "+island2.getX());
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
    public void resume(ActionEvent e) throws IOException {
        //MouseEvent e1=new MouseEvent();
        //switchToGameScreen(e1);
    }

    public void save(ActionEvent e){

    }
    public void exit(ActionEvent e) throws IOException {
        backGame(e);
    }
    public void play(MouseEvent e) throws IOException {
        System.out.println("Play Game");
        switchToGameScreen(e);
    }

    public void movePlayer(MouseEvent e) throws IOException {
        System.out.println(hero);
        hero.moveForward();
//        loc++;
//        score.setText(Integer.toString(loc));
//        System.out.println(score);
//        System.out.println("Move");
//        TranslateTransition translate = new TranslateTransition();
//        TranslateTransition translate1 = new TranslateTransition();
//        TranslateTransition translate3 = new TranslateTransition();
//        TranslateTransition translate4 = new TranslateTransition();
//        TranslateTransition translate5 = new TranslateTransition();
//        TranslateTransition translate6 = new TranslateTransition();
//        TranslateTransition translate7 = new TranslateTransition();
//        TranslateTransition translate8 = new TranslateTransition();
//        TranslateTransition translate9 = new TranslateTransition();
//        translate.setNode(myhero);
//        translate1.setNode(island1);
//
//        Image icon = new Image("island.png");
//        island2=new ImageView(icon);
//        island2.setFitWidth(314);
//        island2.setFitHeight(250);
//        island2.setTranslateX(520);
//        island2.setTranslateY(95);
//        System.out.println(island1.getTranslateX()+" "+island1.getTranslateY()+" "+island2.getTranslateX()+" "+island2.getTranslateY());
//
//        System.out.println(island1.getTranslateX()+" "+island1.getTranslateY()+" "+island2.getTranslateX()+" "+island2.getTranslateY());
//        translate2.setNode(island2);
//        translate2.setDuration(Duration.millis(3000));
//        translate2.setByY(80);
//        translate2.setCycleCount(TranslateTransition.INDEFINITE);
//        translate2.setAutoReverse(true);
//        translate2.setNode(island2);
//        translate3.setNode(gOrc);
//        //translate4.setNode(score);
//        translate5.setNode(island3);
//        translate6.setNode(island4);
//        translate7.setNode(c_chest);
//        //translate8.setNode(score);
//        translate9.setNode(open_chest);
//
//        translate.setDuration(Duration.millis(150));
//        translate1.setDuration(Duration.millis(300));
//        translate2.setDuration(Duration.millis(300));
//        translate5.setDuration(Duration.millis(300));
//        translate6.setDuration(Duration.millis(300));
//        translate3.setDuration(Duration.millis(300));
//        translate7.setDuration(Duration.millis(300));
//        //translate8.setDuration(Duration.millis(300));
//        translate9.setDuration(Duration.millis(300));
//
//        translate.setByX(53);
//        translate1.setByX(-57);
//        translate2.setByX(-57);
//        translate5.setByX(-57);
//        translate6.setByX(-57);
//        translate7.setByX(-57);
//        translate3.setByX(-57);
//        translate9.setByX(-57);
//        myhero.setX(myhero.getX() + 1);
//        island1.setX(-5);
//        System.out.println(island+" "+island2);
//        island2.setX(-5);
//        //island2.setTranslateX(island2.getTranslateX()-57);
//        System.out.println(island1.getTranslateX()+" "+island1.getTranslateY()+" "+island1.getX()+" "+island2.getX()+" "+island2.getTranslateX()+" "+island2.getTranslateY());
//        island3.setX(-5);
//        island4.setX(-5);
//        c_chest.setX(-5);
//        open_chest.setX(-5);
//        gOrc.setX(-5);
//
//        translate.play();
//        translate1.play();
//        //translate3.play();
//        translate4.play();
//        translate5.play();
//        translate6.play();
//        translate7.play();
//        translate9.play();
//        translate.play();
//        System.out.println(myhero.getX());
//        if (myhero.getX() == 5) {
//            c_chest.setOpacity(0);
//            open_chest.setOpacity(1);
//            coins+=5;
//            noOfCoins.setText(Integer.toString(coins));
//
//        }
//        if (myhero.getX() == 9) {
//            gOrc.setX(5);
//            translate3.setByX(57);
//            translate3.play();
//        }
//        if(myhero.getX()==10){
//            gOrc.setX(5);
//            translate3.setByX(57);
//            translate3.setDuration(Duration.millis(30));
//            gOrc.setOpacity(0);
//            translate3.setByY(200);
//            gOrc.setOpacity(0);
//            coins+=10;
//            noOfCoins.setText(Integer.toString(coins));
//            translate3.play();
//        }
//        translate2.play();
//        translate3.play();

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
        TranslateTransition translate1 = new TranslateTransition();
        translate.setNode(myhero);
        translate.setDuration(Duration.millis(500));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        //translate.setByX(50);
        translate.setByY(100);
        translate.setAutoReverse(true);

        translate1.setNode(gOrc);
        translate1.setDuration(Duration.millis(600));
        translate1.setCycleCount(TranslateTransition.INDEFINITE);
        //translate.setByX(50);
        translate1.setByY(150);
        translate1.setAutoReverse(true);
        translate1.play();
        translate.play();
    }

}
