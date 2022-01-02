package sample;

import com.sun.javafx.geom.Shape;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.*;

import java.io.*;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class Game extends Application implements Initializable, Serializable {


    private static Player hero;
    private static LinkedList<Island> island;
    private static LinkedList<Orc> orc;
    private static LinkedList<Obstacle> obstacles;
    private static LinkedList<CoinChest> cchest;
    private static LinkedList<WeaponChest> wchest;
    private static LinkedList<Coin> coinl;

    private static int highScore;
    private int gid;
    private static long serialVersionUID;

    @FXML
    private ImageView movebutton, restartview, resumeview, saveview, exitview;
    @FXML
    Label score, noOfCoins, gameover, resurrect, restartbutton, restartbutton1, resumebutton, savebutton, exiticon;
    TranslateTransition translate2=new TranslateTransition();
    @FXML
    static Button newgamebutton, loadgamebutton, highscorebutton, exitbutton, gameinstr, exitinstr;

    private static LinkedList<TranslateTransition> transitions1, transitions2, transitions3, transitions4, transitions5 ;
    private static TranslateTransition heroTransition;
    private int loc=0;
    private String s="";
    private static ImageView myhero;
    private static boolean status=false, status1=false;
    private static Parent root;
    private static Stage stage;
    private static Scene scene;

    public Game() {

        island=new LinkedList<>();
        orc=new LinkedList<>(); //all orcs including boss
        obstacles=new LinkedList<>(); //obstacles
        cchest=new LinkedList<>(); //coin chests
        wchest=new LinkedList<>(); //weapon chests
        coinl = new LinkedList<>(); //coins
//        placeGameObjects();
        transitions1=new LinkedList<>();
        transitions2=new LinkedList<>();
        transitions3=new LinkedList<>();
        transitions4=new LinkedList<>();
        transitions5=new LinkedList<>();
        heroTransition=new TranslateTransition();

    }



    private void placeGameObjects(MouseEvent event) throws IOException {


        System.out.println("place "+heroTransition);
        root = FXMLLoader.load(getClass().getResource("nayiGameScene.fxml"));
        StackPane pane=(StackPane)root;

        // instantiate hero

        TranslateTransition transitions=new TranslateTransition();
        //placing islands - 22 islands in total
        Coordinates s,e;
        int loc = 0;
        for (int i=0;i<20;i++){
            Image icon = new Image("island.png");
            ImageView img=new ImageView(icon);
            img.setFitWidth(314);
            img.setFitHeight(260);
            if (loc%2==0&&(loc!=6)&&(loc!=24)){
                s = new Coordinates(-370+(450*i), 190);
                e = new Coordinates(-56+(450*i), 190);
                img.setTranslateX(-370+450*i);
                img.setTranslateY(190);
                Island isd = new Island(i+1, s, e,img);
                island.add(isd);
                System.out.println("img "+img);
                pane.getChildren().add(img);
                TranslateTransition t=new TranslateTransition();
                t.setNode(img);
                transitions1.add(t);

            }
            else if ((loc==6)||(loc==24)||(loc==39)||(loc==51)){ //4 moving islands
                //System.out.println("loc: "+loc);
                s = new Coordinates(-370+(450*i), 95);
                e = new Coordinates(-56+(450*i), 95);
                img.setTranslateX(-370+450*i);
                img.setTranslateY(190);
                MovingIsland isd = new MovingIsland(i+1, s, e,img);
                System.out.println(island.size());
                island.add(isd);
                pane.getChildren().add(img);
                TranslateTransition t=new TranslateTransition();
                t.setNode(img);
                transitions1.add(t);
                //set animation for Moving island
                isd.move(new TranslateTransition());

            }
            else{
                s = new Coordinates(-370+(450*i), 190);
                e = new Coordinates(-56+(450*i), 190);
                img.setTranslateX(-370+450*i);
                img.setTranslateY(190);
                Island isd = new Island(i+1, s, e,img);
                island.add(isd);
                pane.getChildren().add(img);
                TranslateTransition t=new TranslateTransition();
                t.setNode(img);
                transitions1.add(t);
            }
            loc += 3;

        }

        for (int i=0;i<4;i++){
            Image icon = new Image("island.png");
            ImageView img=new ImageView(icon);
            img.setFitWidth(314);
            img.setFitHeight(260);
            Coordinates st1, e1;
            st1 = new Coordinates(8630+(314*i), 190);
            e1 = new Coordinates(8630+(314*2*i), 190);
            img.setTranslateX(8630+(314*i));
            img.setTranslateY(190);
            Island isd1 = new Island(21+i, st1, e1,img);
            island.add(isd1);
            pane.getChildren().add(img);
            TranslateTransition t=new TranslateTransition();
            t.setNode(img);
            transitions1.add(t);
        }

        TranslateTransition t=new TranslateTransition();

        //obstacle - TNT
        Image icon1 = new Image("TNT.png");
        ImageView img1=new ImageView(icon1);
        img1.setFitWidth(100);
        img1.setFitHeight(100);
        Image icon01 = new Image("burst.png");
        ImageView img01=new ImageView(icon01);
        img01.setFitWidth(450);
        img01.setFitHeight(450);
        img01.setTranslateX(1500);
        img01.setTranslateY(10);
        img01.setOpacity(0);
        pane.getChildren().add(img01);
        //adding obstacle - TNT
        Coordinates s1, s2;
        s1 = new Coordinates(1500, 10);
        s2 = new Coordinates(5500, 10);
        Obstacle obst1 = new Obstacle(25, s1,img1, img01);
        img1.setTranslateX(1500);
        img1.setTranslateY(10);
        obstacles.add(obst1);
        pane.getChildren().add(img1);
        t=new TranslateTransition();
        t.setNode(img1);
        transitions2.add(t);

        icon1 = new Image("TNT.png");
        img1=new ImageView(icon1);
        img1.setFitWidth(100);
        img1.setFitHeight(100);
        Image icon02 = new Image("burst.png");
        ImageView img02=new ImageView(icon02);
        img02.setFitWidth(450);
        img02.setFitHeight(450);
        img02.setTranslateX(8250);
        img02.setTranslateY(10);
        img02.setOpacity(0);
        pane.getChildren().add(img02);
        Obstacle obst2 = new Obstacle(26, s2,img1, img02);
        obstacles.add(obst2);
        pane.getChildren().add(img1);
        img1.setTranslateX(8250);
        img1.setTranslateY(10);
        t=new TranslateTransition();
        t.setNode(img1);
        transitions2.add(t);

        //adding chests

        int loc_chest = 6;
        for (int i=0;i<2;i++){
            Image icon2 = new Image("ChestClosed.png");
            ImageView img2=new ImageView(icon2);
            img2.setFitWidth(120);
            img2.setFitHeight(90);
            Image icon0 = new Image("ChestOpen.png");
            ImageView img0=new ImageView(icon0);
            img0.setFitWidth(120);
            img0.setFitHeight(90);
            img0.setOpacity(0);
            pane.getChildren().add(img0);
            s = new Coordinates(0,0); //
            if (i==0){
                s = new Coordinates(150, 20);
            }
            else if (i==1){
                s = new Coordinates(4200, 20);
            }
            CoinChest c_chest = new CoinChest(i+27, s, 50,img2, img0); //ids 27 and 28
            cchest.add(c_chest);
            pane.getChildren().add(img2);
            if (i==0){
                img2.setTranslateX(150);
                img0.setTranslateX(150);
            }
            else if (i==1){
                img2.setTranslateX(4200);
                img0.setTranslateX(4200);
            }
            img2.setTranslateY(20);
            img0.setTranslateY(20);
            t=new TranslateTransition();
            t.setNode(img2);
            transitions3.add(t);
            loc_chest += 18; //second coin chest at 24

        }

        loc_chest = 18;
        for (int i=0;i<3;i++){
            Image icon2 = new Image("ChestClosed.png");
            ImageView img2 = new ImageView(icon2);
            img2.setFitWidth(120);
            img2.setFitHeight(90);
            Image icon0 = new Image("ChestOpen.png");
            ImageView img0=new ImageView(icon0);
            img0.setFitWidth(120);
            img0.setFitHeight(90);
            img0.setOpacity(0);
            pane.getChildren().add(img0);
            String[] arr = {"axe", "rocket", "axe"};
            if(i==1){
                s = new Coordinates(6800, 20);
            }
            else{
                s = new Coordinates(2300+(2900*i), 20);
            }
            WeaponChest w_chest = new WeaponChest(i+29, s, arr[i],img2, img0); //ids 29, 30, 31
            wchest.add(w_chest);
            pane.getChildren().add(img2);
            if(i==1){
                img2.setTranslateX(6800);
                img0.setTranslateX(6800);
            }
            else{
                img2.setTranslateX(2300+(2900*i));
                img0.setTranslateX(2300+(2900*i));
            }
            img2.setTranslateY(20);
            img0.setTranslateY(20);
            t=new TranslateTransition();
            t.setNode(img2);
            transitions3.add(t);
            loc_chest += 12;
        }

        //adding Orcs - Green at positions = 3, 7, 9, 13, 15, 19

        int loc_orc = 3;
        for (int i=0;i<6;i++){
            Image icon3 = new Image("greenOrc.jpeg");
            ImageView img3=new ImageView(icon3);
            img3.setFitWidth(90);
            img3.setFitHeight(90);
            if (i==5){
                s = new Coordinates(4500, -150);
            }
            else{
                s = new Coordinates(-10+(950*i), -150);
            }
            GreenOrc orc1 = new GreenOrc(i+32, s, "green", 2, 30, 10,img3);
            orc.add(orc1);
            pane.getChildren().add(img3);
            if (i==5){
                img3.setTranslateX(4500);
            }
            else{
                img3.setTranslateX(-10+(950*i));
            }

            img3.setTranslateY(-300);
            t=new TranslateTransition();
            t.setNode(img3);
            transitions4.add(t);
            if (i%2==0){ //i = 0,2,4
                loc+=4;
            }
            else { //i= 1, 3, 5
                loc += 2;
            }
        }

        //loc_orc = 21 at this point
        //adding Orcs - Red at positions = 21, 25, 27, 31, 33, 37

        for (int i=0;i<4;i++){
            Image icon4 = new Image("redOrc.jpeg");
            ImageView img4=new ImageView(icon4);
            img4.setFitWidth(90);
            img4.setFitHeight(90);
            s = new Coordinates(5000+(950*i), -150);
            RedOrc orc1 = new RedOrc(i+38, s, "red", 2, 40, 10,img4);
            orc.add(orc1);
            t=new TranslateTransition();
            img4.setTranslateX(5000+(950*i));
            img4.setTranslateY(-300);
            t.setNode(img4);
            transitions4.add(t);
            pane.getChildren().add(img4);
            if (i%2==0){ //i = 0,2,4
                loc+=4;
            }
            else { //i= 1, 3, 5
                loc += 2;
            }
        }

        //adding Boss
        Image icon5 = new Image("Boss.png");
        ImageView img5=new ImageView(icon5);
        img5.setFitWidth(200);
        img5.setFitHeight(200);
        Coordinates s0;
        s0 = new Coordinates(9100, -150);
        Boss boss = new Boss(42, s0, "boss", 10, 70, 100,img5);
        orc.add(boss);
        pane.getChildren().add(img5);
        t=new TranslateTransition();
        img5.setTranslateX(9100);
        img5.setTranslateY(-150);
        t.setNode(img5);
        transitions4.add(t);


        int spc = 3500;
        for (int i=0;i<3;i++){
            int spc1 = 50;
            for (int j=0;j<3;j++){
                Image icon6 = new Image("Coin.png");
                ImageView img6 = new ImageView(icon6);
                img6.setFitWidth(50);
                img6.setFitHeight(50);
                if(i==2){
                    img6.setTranslateX(8700 + spc1);
                    img6.setTranslateY(30);
                    s0 = new Coordinates(8700 + spc1 , 30);
                }
                else{
                    img6.setTranslateX(spc + spc1);
                    img6.setTranslateY(30);
                    s0 = new Coordinates(spc + spc1 , 30);
                }
                Coin coin = new Coin(43+i+j, s0, img6);
                coinl.add(coin);
                pane.getChildren().add(img6);
                t=new TranslateTransition();
                t.setNode(img6);
                transitions5.add(t);
                spc1 += 70;
            }
            spc += 2750;
        }

        transitions.play();

        for(int i=0;i<transitions4.size();i++){
            orc.get(i).move(new TranslateTransition());
        }

        //set initial island for hero
        myhero=instantiate_hero();
        pane.getChildren().add(myhero);
        hero.setIsd(island.get(0));
        hero.jump(heroTransition);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setX(150);
        stage.setY(45);
        stage.show();

    }

    public ImageView instantiate_hero(){
        Image icon = new Image("player.png");
        ImageView img=new ImageView(icon);
        img.setFitWidth(75);
        img.setFitHeight(75);
        img.setTranslateX(-450);
        img.setTranslateY(-90);
        hero= Player.getInstance(s,img);
        //System.out.println(myhero+" hero :"+hero.getName());
        return img;
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

    public void loadGame() throws IOException, ClassNotFoundException {
        deserialize();
    }
    public void saveGame(MouseEvent e) throws IOException {
        serialize();
    }
    public void pauseGame(MouseEvent event) throws IOException {
        System.out.println("Game paused");
        restartview.setOpacity(1);
        resumeview.setOpacity(1);
        saveview.setOpacity(1);
        exitview.setOpacity(1);
        resumebutton.setOpacity(1);
        restartbutton.setOpacity(1);
        exiticon.setOpacity(1);
        savebutton.setOpacity(1);
        movebutton.setOpacity(0);
        hero.getMe().setOpacity(0.2);
        for(int i=0;i<island.size();i++){
            island.get(i).getView().setOpacity(0.2);
            //System.out.println("red island");
        }
        for(int i=0;i<orc.size();i++){
            orc.get(i).getView().setOpacity(0.2);
        }
        for(int i=0;i<obstacles.size();i++){
            obstacles.get(i).getView().setOpacity(0);
        }
        for(int i=0;i<cchest.size();i++){
            cchest.get(i).getView().setOpacity(0);
        }
        for(int i=0;i<wchest.size();i++){
            wchest.get(i).getView().setOpacity(0);
        }
        for(int i=0;i<coinl.size();i++){
            coinl.get(i).getView().setOpacity(0);
        }
        //setGameobjectsOpacity(0);
//        Parent root = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.setX(600);
//        stage.show();
    }
    public boolean collision(int x, ImageView i1, ImageView i2){

        if(i1.getBoundsInParent().intersects(i2.getBoundsInParent())){
            System.out.println("collided");
            return true;
        }

        return false;
    }

    public void resumeGame(MouseEvent e){
        restartview.setOpacity(0);
        resumeview.setOpacity(0);
        saveview.setOpacity(0);
        exitview.setOpacity(0);
        resumebutton.setOpacity(0);
        restartbutton.setOpacity(0);
        exiticon.setOpacity(0);
        savebutton.setOpacity(0);
        hero.getMe().setOpacity(1);
        movebutton.setOpacity(0);
        for(int i=0;i<island.size();i++){
            island.get(i).getView().setOpacity(1);
            //System.out.println("red island");
        }
        for(int i=0;i<orc.size();i++){
            orc.get(i).getView().setOpacity(1);
        }
        for(int i=0;i<obstacles.size();i++){
            obstacles.get(i).getView().setOpacity(1);
        }
        for(int i=1;i<cchest.size();i++){
            cchest.get(i).getView().setOpacity(1);
        }
        for(int i=0;i<wchest.size();i++){
            wchest.get(i).getView().setOpacity(1);
        }
        for(int i=0;i<coinl.size();i++){
            coinl.get(i).getView().setOpacity(1);
        }
    }
    public void restartGame(MouseEvent e) throws IOException {
        // go to Main menu
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setX(600);
        stage.show();

    }

    public void exitGame(ActionEvent e){
        System.exit(0);
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
    public void serialize() throws IOException{

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("out.txt"));
            out.writeObject(this);
        }
        finally {
            out.close();
        }
    }
    public void deserialize() throws IOException, ClassNotFoundException{
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream (new FileInputStream("out.txt"));
            Game g= (Game) in.readObject();
        }
        finally {
            in.close();
        }

    }

    public static void main(String[] args) {
        launch(args);
        Game g = new Game();

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


    public void restart(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setX(600);
        stage.show();
    }
    public void entername(KeyEvent e){
        s+=e.getCharacter();
    }
    public void startGame(MouseEvent event) throws IOException {

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

    public void play(MouseEvent e) throws IOException {
        System.out.println("Play Game");
        //switchToGameScreen(e);
        placeGameObjects(e);
    }

    public void moveScreen(){
        //animate game objects

        Iterator it1 = transitions1.iterator();
        Iterator it3 = transitions3.iterator();

        for(int i=0;i<island.size();i++){
            transitions1.get(i).setDuration(Duration.millis(300));
            transitions1.get(i).setByX(-75);
            transitions1.get(i).play();
        }
        for(int i=0;i<obstacles.size();i++){
            transitions2.get(i).setDuration(Duration.millis(300));
            transitions2.get(i).setByX(-75);
            transitions2.get(i).play();
        }
        for(int i=0;i<cchest.size();i++){
            transitions3.get(i).setDuration(Duration.millis(300));
            transitions3.get(i).setByX(-75);
            transitions3.get(i).play();
        }
        for(int i=0;i<wchest.size();i++){
            transitions3.get(i).setDuration(Duration.millis(300));
            transitions3.get(i).setByX(-75);
            transitions3.get(i).play();
        }
        for(int i=0;i<orc.size();i++){
            transitions4.get(i).setDuration(Duration.millis(300));
            transitions4.get(i).setByX(-75);
            transitions4.get(i).play();
        }
        for(int i=0;i<coinl.size();i++){
            transitions5.get(i).setDuration(Duration.millis(300));
            transitions5.get(i).setByX(-75);
            transitions5.get(i).play();
        }

    }

    public void movePlayer(MouseEvent e) throws InterruptedException, IOException {
        //System.out.println(island.get(0).getView().getTranslateX());
        moveScreen();
        hero.moveForward();
        score.setText(Integer.toString(hero.getNumberOfMoves()));
        noOfCoins.setText(Integer.toString(hero.getCoins()));
//        if(hero.getIsd()==null){
//            heroTransition.setAutoReverse(false);
//            heroTransition.setByY(300);
//        }
        //check island for hero
//        boolean iffall=hero.updateIsland(island);
//        TranslateTransition tt=new TranslateTransition();
//        if(iffall){
//
//            tt.setNode(hero.getMe());
//            tt.setAutoReverse(false);
//            tt.setDuration(Duration.millis(3000));
//            //tt.setCycleCount(Animation.INDEFINITE);
//            tt.setByY(hero.getMe().getTranslateY()+600);
//
//            //hero.getMe().setTranslateY(300);
//            heroTransition.stop();
//            tt.play();
//            System.out.println(iffall);



//            heroTransition.setAutoReverse(false);
//            heroTransition.setByY(300);
//            heroTransition.play();
            //fall hero into the abyss
            //hero.fall(heroTransition);
            //hero.fall(heroTransition);
            //stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            //scene = new Scene(root);
//            stage.setScene(scene);
//            stage.setX(150);
//            stage.setY(45);
//            stage.show();
//        }
//        else {
//            tt.stop();
//            heroTransition.play();

        for (int i=0;i<orc.size();i++) {
            int finalI = i;
//            AnimationTimer collisionTimer=new AnimationTimer() {
//                @Override
//                public void handle(long l) {
//                    //checkCollisionChest(myImage,chest);
//                    int status =  hero.CollideGameObject(orc.get(finalI), orc.get(finalI).getId());
//                    if(status==1){
//                        System.out.println("1 hai");
//                        try {
//                            overgame(orc.get(finalI));
//                        } catch (IOException ioException) {
//                            ioException.printStackTrace();
//                        }
//                    }
//                }
//            };
            int status =  hero.CollideGameObject(orc.get(i), orc.get(i).getId());
          if(status==1){
              System.out.println("1 hai");
              orc.get(i).slide(new TranslateTransition());
              TranslateTransition t1 = new TranslateTransition();
              t1.setDuration(Duration.seconds(2));
              int finalI1 = i;
              t1.setOnFinished(actionEvent -> orc.get(finalI1).getView().setOpacity(0));
              //overgame(orc.get(i));
          }

        }

        for (int i=0;i<obstacles.size();i++) {
           int status =  hero.CollideGameObject(obstacles.get(i), obstacles.get(i).getId());
           if (status==1){
               //heroTransition.stop();
               obstacles.get(i).getView1().setTranslateX(obstacles.get(i).getView().getTranslateX()-65);
               obstacles.get(i).getView1().setTranslateY(obstacles.get(i).getView().getTranslateY());
               transitions3.get(i).setNode(obstacles.get(i).getView1());
               obstacles.get(i).getView1().setOpacity(1);
               obstacles.get(i).getView().setOpacity(0);
               //over game or choose resurrect
               //overgame(obstacles.get(i));
           }
        }

        for (int i=0;i<coinl.size();i++) {
            hero.CollideGameObject(coinl.get(i), coinl.get(i).getId());
        }

        for (int i=0;i<cchest.size();i++) {
            int status = hero.CollideGameObject(cchest.get(i), cchest.get(i).getId());
            if (status==1){
                cchest.get(i).getView1().setTranslateX(cchest.get(i).getView().getTranslateX()-65);
                cchest.get(i).getView1().setTranslateY(cchest.get(i).getView().getTranslateY());
                transitions3.get(i).setNode(cchest.get(i).getView1());
                cchest.get(i).getView1().setOpacity(1);

            }
        }

        for (int i=0;i<wchest.size();i++) {
            int status = hero.CollideGameObject(wchest.get(i), wchest.get(i).getId());
            if (status==1){
                wchest.get(i).getView1().setTranslateX(wchest.get(i).getView().getTranslateX()-65);
                wchest.get(i).getView1().setTranslateY(wchest.get(i).getView().getTranslateY());
                transitions3.get(i).setNode(wchest.get(i).getView1());
                wchest.get(i).getView1().setOpacity(1);

            }
        }
        if(hero.getH().getWeapon().get(0).getWeaponActiveStatus()){
            hero.getH().getWeapon().get(0).useWeapon(hero.getMe().getTranslateX());
        }
        if(hero.getH().getWeapon().get(1).getWeaponActiveStatus()){
            hero.getH().getWeapon().get(1).useWeapon(hero.getMe().getTranslateX());
        }

    }
    private void setGameobjectsOpacity(int s){
        movebutton.setOpacity(s);
        for(int i=0;i<island.size();i++){
            island.get(i).getView().setOpacity(0.2 + 0.8*s);
            //System.out.println("red island");
        }
        for(int i=0;i<orc.size();i++){
            orc.get(i).getView().setOpacity(0.2+ 0.8*s);
        }
        for(int i=0;i<obstacles.size();i++){
            obstacles.get(i).getView().setOpacity(s);
        }
        for(int i=0;i<cchest.size();i++){
            cchest.get(i).getView().setOpacity(s);
        }
        for(int i=0;i<wchest.size();i++){
            wchest.get(i).getView().setOpacity(s);
        }
        for(int i=0;i<coinl.size();i++){
            coinl.get(i).getView().setOpacity(s);
        }
    }
    public void overgame(GameObjects o) throws IOException {
//        Parent root1 = FXMLLoader.load(getClass().getResource("overgame.fxml"));
//        Stage stage=new Stage();
//        Scene scene = new Scene(root1);
//        stage.setScene(scene);
//        stage.show();

        //reducing opacities of all game objects
        //System.out.println("reduce");
        //setGameobjectsOpacity(0);
        gameover.setOpacity(1);
        movebutton.setOpacity(0);
        for(int i=0;i<island.size();i++){
            island.get(i).getView().setOpacity(0.2);
            //System.out.println("red island");
        }
        for(int i=0;i<orc.size();i++){
            orc.get(i).getView().setOpacity(0.2);
        }
        for(int i=0;i<obstacles.size();i++){
            obstacles.get(i).getView().setOpacity(0);
        }
        for(int i=0;i<cchest.size();i++){
            cchest.get(i).getView().setOpacity(0);
        }
        for(int i=0;i<wchest.size();i++){
            wchest.get(i).getView().setOpacity(0);
        }
        for(int i=0;i<coinl.size();i++){
            coinl.get(i).getView().setOpacity(0);
        }
        if(o instanceof Obstacle) {

            if (hero.getCoins() >= 50) {
                resurrect.setOpacity(1);
            } else {
                //game over
                System.exit(0);
            }
        }
        else if(o instanceof Orc){
            resurrect.setOpacity(0.5);

        }

        restartbutton1.setOpacity(1);
    }
    public void resurrectHero(MouseEvent e){
        gameover.setOpacity(0);
        resurrect.setOpacity(0);
        movebutton.setOpacity(1);
        for(int i=0;i<island.size();i++){
            island.get(i).getView().setOpacity(1);
            //System.out.println("red island");
        }
        for(int i=0;i<orc.size();i++){
            orc.get(i).getView().setOpacity(1);
        }
        obstacles.get(1).getView().setOpacity(1);
        for(int i=1;i<cchest.size();i++){
            cchest.get(i).getView().setOpacity(1);
        }
        for(int i=0;i<wchest.size();i++){
            wchest.get(i).getView().setOpacity(1);
        }
        for(int i=0;i<coinl.size();i++){
            coinl.get(i).getView().setOpacity(1);
        }

        hero.useCoins();
        noOfCoins.setText(Integer.toString(hero.getCoins()));
        hero.getMe().setOpacity(1);
        heroTransition.setByY(heroTransition.getByY()-20);
        heroTransition.play();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
