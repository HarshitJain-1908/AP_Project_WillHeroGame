package sample;

import javafx.scene.image.ImageView;

public class Obstacle extends GameObjects {
    private int timer;
    private ImageView i0;

    public Obstacle(int id, Coordinates c, ImageView i, ImageView i1){
        super(id,c,i);
        timer=2;
        i0 = i1;
    }

    public int getTimer() {
        return timer;
    }
    public ImageView getView1(){
        return i0;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

}
