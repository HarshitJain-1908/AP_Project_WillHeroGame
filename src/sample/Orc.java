package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

abstract public class Orc extends GameObjects {
    private int power;
    private final int size;
    private int reward;
    private final String type;
    private final int jumpHeight;

    public Orc(int id, Coordinates c, String t, int s, int p, int r, ImageView i){
        super(id,c,i);
        jumpHeight=2;
        type=t;
        size=s;
        power=p;
        reward=r;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public int getPower() {
        return power;
    }

    public int getReward() {
        return reward;
    }

    public int getSize() {
        return size;
    }
    public void jump(){

    }
    @Override
    public void move(TranslateTransition t1){
        this.t=t1;
        t.setNode(me);
        t.setDuration(Duration.millis(800));
        t.setCycleCount(TranslateTransition.INDEFINITE);
        t.setByY(320);
        t.setAutoReverse(true);
        t.play();
    }

    @Override
    public void slide(){

    }
    abstract public void killHero();
}