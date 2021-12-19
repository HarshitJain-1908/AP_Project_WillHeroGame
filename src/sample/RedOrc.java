package sample;

import javafx.scene.image.ImageView;

public class RedOrc extends Orc {

    public RedOrc(int id, Coordinates c, String t, int s, int p, int r, ImageView i){
        //s - size, p - power, r -reward , t - type
        super(id,c,t,s,p,r,i);
    }
    @Override
    public void killHero(){

    }
    public void upDatePower(int p){

    }
}
