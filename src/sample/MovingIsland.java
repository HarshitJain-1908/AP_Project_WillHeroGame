package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class MovingIsland extends Island {
    private float speed;

    public MovingIsland(int id, Coordinates c, Coordinates e, ImageView i) {
        super(id, c, e, i);
        speed=1/12;
    }
    //@Override
    public void move(TranslateTransition t1){
        //System.out.println("move island");
        this.t=t1;
        t.setNode(me);
        t.setDuration(Duration.millis(1200));
        t.setByY(100);
        t.setCycleCount(TranslateTransition.INDEFINITE);
        t.setAutoReverse(true);
        t.play();
    }
}
