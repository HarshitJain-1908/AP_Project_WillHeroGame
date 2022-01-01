package sample;

import javafx.scene.image.ImageView;

public class WeaponChest extends GameObjects implements Treasure {
    private Weapon weapon;
    private ImageView i0;

    public WeaponChest(int id, Coordinates c, String t, ImageView i, ImageView i1){
        super(id,c,i);
        i0=i1;
        if(t.equals("Axe")){
            weapon = new Axe();
        }
        else{
            weapon = new Rocket();
        }

    }

    public ImageView getView1(){
        return i0;
    }
    @Override
    public void openTreasure(){

    }
}
