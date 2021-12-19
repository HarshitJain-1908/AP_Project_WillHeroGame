package sample;

import javafx.scene.image.ImageView;

public class MovingIsland extends Island {
    private float speed;

    public MovingIsland(int id, Coordinates c, Coordinates e, ImageView i) {
        super(id, c, e, i);
        speed=2;
    }
}
