package sample;

import javafx.scene.image.ImageView;

public class Boss extends GreenOrc {

    public Boss(int id, Coordinates c, String t, int s, int p, int r, ImageView i){
        super(id,c,t,s,p,r,i);
    }
    @Override
    public void killHero(){

        //this function will kill the player
    }
    public void upDatePower(int p){

    }
    public void enterInGame(){

    }
}

