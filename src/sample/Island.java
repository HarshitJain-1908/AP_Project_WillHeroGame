package sample;

import javafx.scene.image.ImageView;

public class Island extends GameObjects {
    private Coordinates endCoord;

    public Island(int id, Coordinates c, Coordinates e, ImageView i){
        super(id,c,i);
        endCoord=e;


    }
}
