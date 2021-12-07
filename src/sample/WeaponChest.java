package sample;

public class WeaponChest extends GameObjects implements Treasure {
    private Weapon weapon;

    public WeaponChest(int id, Coordinates c, String t){
        super(id,c);
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
