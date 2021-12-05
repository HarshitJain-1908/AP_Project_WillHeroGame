package sample;

import java.util.ArrayList;


public class Helmet {
    private ArrayList<Weapon> weapon;

    public Helmet(){
        weapon=new ArrayList<>(2);
        weapon.add(new Axe());
        weapon.add(new Rocket());
    }
    public void upgradeWeapon(){

    }


}
