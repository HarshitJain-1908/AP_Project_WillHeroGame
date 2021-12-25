package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class CoinChest extends GameObjects implements Treasure {
    private int numberOfCoins;

    public CoinChest(int id, Coordinates c, int n, ImageView i){
        super(id,c,i);
        numberOfCoins=n;
    }

    @Override
    public void openTreasure(){

    }

}