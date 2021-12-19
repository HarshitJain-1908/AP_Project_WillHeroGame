package sample;

import javafx.scene.image.ImageView;

public class WeaponChest extends GameObjects implements Treasure {
    private Weapon weapon;

    public WeaponChest(int id, Coordinates c, String t, ImageView i){
        super(id,c,i);
        if(t.equals("Axe")){
            weapon = new Axe();
        }
        else{
            weapon = new Rocket();
        }

    }
    @Override
    public void openTreasure(){

    }
}
