package sample;

import javafx.scene.image.ImageView;

public class Obstacle extends GameObjects {
    private int timer;

    public Obstacle(int id, Coordinates c, ImageView i){
        super(id,c,i);
        timer=2;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }
    @Override
    public void slide(){

    }

}
