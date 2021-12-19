package sample;

import javafx.scene.image.ImageView;

abstract public class GameObjects {
    private Coordinates coord;
    private int id;

    private ImageView me;

    public GameObjects(int id, Coordinates c, ImageView i){
        coord=c;
        this.id=id;
        me=i;
    }

    public int getId() {
        return id;
    }
    public void slide(){

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
