package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

abstract public class GameObjects {
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
    public void move(TranslateTransition t){
        this.t=t;
        t.setNode(me);
        t.setDuration(Duration.millis(1200));
        t.setByY(100);
        t.setCycleCount(TranslateTransition.INDEFINITE);
        t.setAutoReverse(true);
        t.play();
    }
    public void slide(){
        System.out.println("slide");
        TranslateTransition t=new TranslateTransition();
        t.setNode(me);
        t.setDuration(Duration.millis(1000));
        t.setByX(50);
        t.setCycleCount(TranslateTransition.INDEFINITE);
        //t.setAutoReverse(true);
        t.play();
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
