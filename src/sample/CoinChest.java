package sample;

import javafx.scene.image.ImageView;

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