package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class CoinChest extends GameObjects implements Treasure {
    private int numberOfCoins;
    private ImageView i0;

    public CoinChest(int id, Coordinates c, int n, ImageView i, ImageView i1){
        super(id,c,i);
        numberOfCoins=n;
        i0=i1;
    }

    public ImageView getView1(){
        return i0;
    }

    @Override
    public void openTreasure(){

    }

}