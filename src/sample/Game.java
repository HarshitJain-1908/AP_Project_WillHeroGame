package sample;

import javax.swing.text.html.HTMLDocument;
import java.io.Serializable;
import java.util.LinkedList;

public class Game implements Serializable {
    private Player hero;
    private LinkedList<GameObjects> gameObjects;
    private LinkedList<Island> island;
    private LinkedList<Orc> orc;
    private LinkedList<Obstacle> obstacles;
    private LinkedList<Treasure> chests;

    private static int highScore;
    private int gid;
    private static long serialVersionUID;

    public Game(){
        //System.out.println("Enter the name: ");

        hero = new Player("mickey");
        gameObjects = new LinkedList<>();
        island=new LinkedList<>();
        orc=new LinkedList<>(); //all orcs including boss
        obstacles=new LinkedList<>(); //obstacles
        chests=new LinkedList<>(); //chests
        placeGameObjects();

    }
    private void placeGameObjects(){
        //placing islands - 22 islands in total
        Coordinates s,e;
        int loc = 0;
        for (int i=0;i<20;i++){
            if (loc%2==0){
                s = new Coordinates(loc, 0);
                e = new Coordinates(loc+2, 0);
                Island isd = new Island(i+1, s, e);
                island.add(isd);
            }
            else if (loc%2==1 && loc%9==0){ //moving islands at 9, 27, 45
                s = new Coordinates(loc, 0);
                e = new Coordinates(loc+1, 0);
                MovingIsland isd = new MovingIsland(i+1, s, e);
                island.add(isd);
            }
            else{
                s = new Coordinates(loc, 0);
                e = new Coordinates(loc+1, 0);
                Island isd = new Island(i+1, s, e);
                island.add(isd);
            }
            loc += 3;
        }
        Coordinates st1, e1, st2,  e2;
        st1 = new Coordinates(58, 0);
        e1 = new Coordinates(60, 0);
        st2 = new Coordinates(60, 0);
        e2 = new Coordinates(61, 0);
        Island isd1 = new Island(21, st1, e1);
        Island isd2 = new Island(22, st2, e2);
        island.add(isd1);
        island.add(isd2);

        //adding obstacle - TNT at coordinates 12 and 36
        Coordinates s1, s2;
        s1 = new Coordinates(12, 0);
        s2 = new Coordinates(36, 0);
        Obstacle obst1 = new Obstacle(23, s1);
        obstacles.add(obst1);
        Obstacle obst2 = new Obstacle(24, s2);
        obstacles.add(obst2);

        //adding chests: coin chest at coordinates 6 and 24, weapon chest at coordinates 18, 30 and 42
        int loc_chest = 6;
        for (int i=0;i<2;i++){
            s = new Coordinates(loc_chest, 0);
            CoinChest c_chest = new CoinChest(i+25, s, 50); //ids 25 and 26
            chests.add(c_chest);
            loc_chest += 18; //second coin chest at 24
        }

        loc_chest = 18;
        for (int i=0;i<3;i++){
            String[] arr = {"axe", "rocket", "axe"};
            s = new Coordinates(loc_chest, 0);
            WeaponChest w_chest = new WeaponChest(i+27, s, arr[i]); //ids 27, 28 and 29
            chests.add(w_chest);
            loc_chest += 12;
        }

        //adding Orcs - Green at positions = 3, 7, 9, 13, 15, 19
        int loc_orc = 3;
        for (int i=0;i<6;i++){
            s = new Coordinates(loc_orc, 0);
            GreenOrc orc1 = new GreenOrc(i+30, s, "green", 2, 30, 10);
            orc.add(orc1);
            if (i%2==0){ //i = 0,2,4
                loc+=4;
            }
            else { //i= 1, 3, 5
                loc += 2;
            }
        }

        //loc_orc = 21 at this point
        //adding Orcs - Red at positions = 21, 25, 27, 31, 33, 37
        for (int i=0;i<6;i++){
            s = new Coordinates(loc_orc, 0);
            RedOrc orc1 = new RedOrc(i+36, s, "red", 2, 40, 10);
            orc.add(orc1);
            if (i%2==0){ //i = 0,2,4
                loc+=4;
            }
            else { //i= 1, 3, 5
                loc += 2;
            }
        }

        //adding Boss
        Coordinates s0;
        s0 = new Coordinates(58, 0);
        Boss boss = new Boss(52, s0, "boss", 10, 70, 100);
        orc.add(boss);

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

