package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class Player {
    private int numberOfMoves;
    private final int jumpHeight;
    private final int moveLength;
    private int coins;
    private Helmet h;
    private Coordinates coord;
    private String name;
    private Game game;

    private ImageView me;


    public Player(String s, ImageView i) {
        jumpHeight = 120;
        moveLength = 75;
        coins = 0;
        coord=new Coordinates(0,0);
        name=s;
        numberOfMoves=0;
        h=new Helmet();
        me=i;
    }
    public void jump(TranslateTransition heroTransition){
        System.out.println("jump "+me);
        heroTransition.setNode(me);
        heroTransition.setDuration(Duration.millis(500));
        heroTransition.setCycleCount(TranslateTransition.INDEFINITE);
        heroTransition.setByY(jumpHeight);
        heroTransition.setAutoReverse(true);
        heroTransition.play();
    }
    public void moveForward(){
        numberOfMoves++;

    }
    public String getName() {
        return name;
    }

    public Helmet getH() {
        return h;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public int getMoveLength() {
        return moveLength;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setCoord(float x, float y) {
        coord.setX(x);
        coord.setY(y);
    }
    public void enterMenu(){

    }
    public void playGame(){

    }
    public void saveGame(){

    }
    public void loadGame(){

    }
    public void pauseGame(){

    }
    public void resumeGame(){

    }
    public void restartGame(){

    }
    public void useCoins(){

    }
    public void exitGame(){

    }
    public void CollideGameObject(ImageView i1, ImageView i2, String s, int x){ //need to add these objects to linked list - a general gameObjects list
        if (s.equals("c_chest")){
            if(i1.getBoundsInParent().intersects(i2.getBoundsInParent())){
                Image icon = new Image("ChestOpen.png");
                ImageView img=new ImageView(icon);
                double a = i1.getTranslateX();
                double b = i1.getTranslateY();
                img.setTranslateX(a);
                img.setTranslateY(b);
                img.setOpacity(0);
                i2.setOpacity(0);
                img.setOpacity(1);
                x += 50;
            }
        }

        if (s.equals("w_chest")){ //not complete yet
            if(i1.getBoundsInParent().intersects(i2.getBoundsInParent())){
                Image icon = new Image("ChestOpen.png");
                ImageView img=new ImageView(icon);
                double a = i1.getTranslateX();
                double b = i1.getTranslateY();
                img.setTranslateX(a);
                img.setTranslateY(b);
                img.setOpacity(0);
                i2.setOpacity(0);
                img.setOpacity(1);
            }
        }

        else if (s.equals("coin")){
            if(i1.getBoundsInParent().intersects(i2.getBoundsInParent())){
                i1.setOpacity(0);
                x++;
            }
        }
        else if (s.equals("TNT")){
            if(i1.getBoundsInParent().intersects(i2.getBoundsInParent())){
                Image icon = new Image("bursting.jpeg");
                ImageView img=new ImageView(icon);
                double a = i1.getTranslateX();
                double b = i1.getTranslateY();
                img.setTranslateX(a);
                img.setTranslateY(b);
                img.setOpacity(0);
                i2.setOpacity(0);
                img.setOpacity(1);
            }
        }
    }
}
