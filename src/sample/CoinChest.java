package sample;

public class CoinChest extends GameObjects implements Treasure {
    private int numberOfCoins;

    public CoinChest(int id, Coordinates c, String t, int n){
        super(id,c);
        numberOfCoins=n;
    }
    @Override
    public void openTreasure(){

    }

}