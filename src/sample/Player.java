package sample;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.util.LinkedList;

import static java.lang.Thread.sleep;

public class Player {
    private int numberOfMoves;
    private final int jumpHeight;
    private final int moveLength;
    private int coins;
    private Helmet h;
    private Coordinates coord;
    private String name;
    private Game game;
    private Island isd;
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
    public void fall(TranslateTransition heroTransition){
        System.out.println("fall");
        heroTransition.setNode(me);
        heroTransition.setDuration(Duration.millis(500));
        heroTransition.setCycleCount(TranslateTransition.INDEFINITE);
        heroTransition.setByY(1000);
        //heroTransition.setAutoReverse(true);
        heroTransition.play();
    }
    public void moveForward(){
        numberOfMoves++;

    }

    public ImageView getMe() {
        return me;
    }

    public boolean updateIsland(LinkedList<Island> i){
       // int count=0;
        System.out.println("current island "+isd+" "+i.size());
        for(int j=0;j<i.size();j++) {

            Island iland = i.get(j);
            //System.out.println(iland.getView().get);

            if (( (me.getTranslateX()-me.getFitWidth()/2) > (iland.getView().getTranslateX()-iland.getView().getFitWidth()/2)) &&
                    ( (me.getTranslateX()+me.getFitWidth()/2)) < (iland.getView().getTranslateX()+iland.getView().getFitWidth()/2)) {
                System.out.println((iland.getView().getTranslateX() - iland.getView().getFitWidth() / 2) + " " + (me.getTranslateX() - me.getFitWidth() / 2) + " " + (me.getTranslateX() + me.getFitWidth() / 2) + " " + (iland.getView().getTranslateX() + iland.getView().getFitWidth() / 2));
                //System.out.println(iland.getView().getTranslateX());
                //System.out.println((me.getTranslateX()-me.getFitWidth()/2)+" " +(iland.getView().getTranslateX() - iland.getView().getFitWidth()/2)+" "+(me.getTranslateX()+me.getFitWidth()/2)+" "+ (iland.getView().getTranslateX()+ iland.getView().getFitWidth()/2));
                //System.out.println(me.getFitWidth());

                setIsd(iland);
                System.out.println("island set " + isd);
                // count = 1;
                return false;
            }

//            }else{
//                System.out.println("else");
//                System.out.println((iland.getView().getTranslateX()-iland.getView().getFitWidth()/2) +" "+(me.getTranslateX()-me.getFitWidth()/2)+" "+(me.getTranslateX()+me.getFitWidth()/2)+" "+(iland.getView().getTranslateX()+iland.getView().getFitWidth()/2));
//
//                //System.out.println((me.getTranslateX()-me.getFitWidth()/2)+" " +(iland.getView().getTranslateX() - iland.getView().getFitWidth()/2)+" "+(me.getTranslateX()+me.getFitWidth()/2)+" "+ (iland.getView().getTranslateX()+ iland.getView().getFitWidth()/2));
//
//            }
        }
        //System.out.println((me.getTranslateX()-me.getFitWidth()/2)+" " +(iland.getView().getTranslateX() - iland.getView().getFitWidth()/2)+" "+(me.getTranslateX()+me.getFitWidth()/2)+" "+ (iland.getView().getTranslateX()+ iland.getView().getFitWidth()/2));
        //System.out.println(me.getFitWidth());
            setIsd(null);
            System.out.println("null h");
            return true;
    }
    public Island getIsd() {
        return isd;
    }

    public void setIsd(Island isd) {
        this.isd = isd;
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

//    //public void setCoins(int coins) {
//        this.coins = coins;
//    }

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
        coins-=50;
    }
    public void exitGame(){

    }
    public int CollideGameObject(GameObjects i2, String s){ //need to add these objects to linked list - a general gameObjects list
        if (s.equals("c_chest")){
            if(me.getBoundsInParent().intersects(i2.getView().getBoundsInParent()) && i2.getFlag()==false){
                i2.getView().setOpacity(0);
                coins += 50;
                i2.setFlag(true);
                return 1;
            }
        }

        if (s.equals("w_chest")){ //not complete yet
            if(me.getBoundsInParent().intersects(i2.getView().getBoundsInParent()) && i2.getFlag()==false){
                i2.getView().setOpacity(0);
                i2.setFlag(true);
                return 1;
            }
        }

        else if (s.equals("coin")){
            if(me.getBoundsInParent().intersects(i2.getView().getBoundsInParent()) && i2.getFlag()==false){
                i2.getView().setOpacity(0);
                i2.setFlag(true);
                coins++;
            }
        }
        else if (s.equals("TNT")){
            if(me.getBoundsInParent().intersects(i2.getView().getBoundsInParent()) && i2.getFlag()==false){
                //System.out.println(i2.getClass()+" "+i2);
                i2.slide();
//                TranslateTransition t=new TranslateTransition();
//                t.setDuration(Duration.millis(2000));
//                t.play();
                i2.getView().setOpacity(0);
                //t.setOnFinished(actionEvent -> i2.getView().setOpacity(0));
                me.setOpacity(0);
                i2.setFlag(true);
                return 1;
            }
        }

        return 0;
    }
}
