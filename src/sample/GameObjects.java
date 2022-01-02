package sample;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.Serializable;

abstract public class GameObjects implements Serializable {
    private Coordinates coord;
    private int id;
    private boolean flag;

    protected ImageView me;
    protected TranslateTransition t;

    public GameObjects(int id, Coordinates c, ImageView i){
        coord=c;
        this.id=id;
        me=i;
        t=new TranslateTransition();
        flag = false;
    }
    public ImageView getView(){
        return me;
    }
    public int getId() {
        return id;
    }
    public boolean getFlag() {
        return flag;
    }
    public boolean setFlag(boolean v) {
        return flag=v;
    }

    public TranslateTransition getT() {
        return t;
    }
    public Coordinates getCoord(){
        return coord;
    }
    public void move(TranslateTransition t1){

        this.t=t1;
        t.setNode(me);
        t.setDuration(Duration.millis(1200));
        t.setByY(100);
        t.setCycleCount(TranslateTransition.INDEFINITE);
        t.setAutoReverse(true);
        t.play();
    }
    public final void collisionImpact(TranslateTransition t1, TranslateTransition t2){ //using template design pattern
        TranslateTransition t3=slide(t1);
        TranslateTransition t4=fall(t2);
//        t3.stop();
//        t4.stop();
        //this.getT().setAutoReverse(false);
        //me.setTranslateY(1000);
//        t.setNode(me);
//        t.setDuration(Duration.millis(1000));
//        t.setByY(1000);
//        t.setCycleCount(TranslateTransition.INDEFINITE);
//        t.play();
    }
    public TranslateTransition slide(TranslateTransition t){
        //System.out.println("slide");
        t.setNode(me);
        t.setDuration(Duration.millis(1000));
        t.setByX(50);
        t.setAutoReverse(false);
        t.setCycleCount(TranslateTransition.INDEFINITE);
        t.play();
        return t;
    }
    public TranslateTransition fall(TranslateTransition t){
        //me.setOpacity(0);
        t.setNode(me);
        t.setDuration(Duration.millis(1000));
        t.setByY(500);
        t.setAutoReverse(false);
        t.setCycleCount(TranslateTransition.INDEFINITE);
        t.play();
        return t;

    }
    @Override
    public boolean equals(Object o) {
        if (this.getClass() == o.getClass()) {
            GameObjects obj = (GameObjects) o;
            return this.id == obj.id;
        } else {
            return false;
        }
    }
}
