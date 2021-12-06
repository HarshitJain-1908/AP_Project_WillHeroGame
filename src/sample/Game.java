package sample;

import java.io.Serializable;
import java.util.LinkedList;

public class Game implements Serializable {
    private Player hero;
    private LinkedList<GameObjects> gameObjects;
    private LinkedList<Island> island;
    private LinkedList<Orc> orc;
    private LinkedList<Obstacle> o;
    private LinkedList<WeaponChest> w;
    private LinkedList<CoinChest> c;

    private static int highScore;
    private int gid;
    private static long serialVersionUID;

    public Game(){
        //System.out.println("Enter the name: ");

        hero = new Player("mickey");
        gameObjects = new LinkedList<>();
        island=new LinkedList<>();
        orc=new LinkedList<>();
        o=new LinkedList<>();
        w=new LinkedList<>();
        c=new LinkedList<>();
        placeGameObjects();

    }
    private void placeGameObjects(){
        //placing islands
        Coordinates s,e;
        s=new Coordinates(0,0);
        e=new Coordinates(2,0);
        Island isd=new Island(1,s,e);
        island.add(isd);
        //s.setX();

    }
    public void enterScreen(){

    }
    public void playGame(){

    }
    public void saveGame(){

    }
    public void loadGame(){

    }
    public void pauseGame(){

    }
    public void resumeGame(){

    }
    public void restartGame(){

    }
    public void useCoins(){

    }
    public void exitGame(){

    }
    public boolean ifHighScore(){
        return true;
    }
    public void updateHighScore(){

    }
    public void viewHighScore(){

    }
    public void upgradeHeroWeapon(){

    }
    public void setHeroWeapon(){

    }
    public void updateHeroLocation(){

    }

    public int getGid() {
        return gid;
    }
    public void serialize()
    {

    }
    public void deserialize(){
    }
}

