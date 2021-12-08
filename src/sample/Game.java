package sample;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

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
        System.out.println("Enter the name: ");
        System.out.println("hello");
        hero = new Player("mickey");
        gameObjects = new LinkedList<>();
        island=new LinkedList<>();
        orc=new LinkedList<>(); //all orcs including boss
        obstacles=new LinkedList<>(); //obstacles
        chests=new LinkedList<>(); //chests
        placeGameObjects();

    }
    private void placeGameObjects(){
        //placing islands
        Coordinates s,e;
        int loc = 0;
        for (int i=0;i<20;i++){
            if (loc%2==0){
                s = new Coordinates(loc, 0);
                e = new Coordinates(loc+2, 0);
                Island isd = new Island(i+1, s, e);
                island.add(isd);
            }
            else if (loc%2==1){
                s = new Coordinates(loc, 0);
                e = new Coordinates(loc+1, 0);
                Island isd = new Island(i+1, s, e);
                island.add(isd);
            }
            loc += 3;
        }

        //adding obstacle - TNT
        Coordinates s1, s2;
        s1 = new Coordinates(12, 0);
        s2 = new Coordinates(36, 0);
        Obstacle obst1 = new Obstacle(21, s1);
        obstacles.add(obst1);
        Obstacle obst2 = new Obstacle(22, s2);
        obstacles.add(obst2);

        //adding Orcs - Green
        for (int i=0;i<6;i++){

        }

        //adding Orcs - Red

        //adding Boss

        //adding chests - not complete yet - needs correction
        int loc_chest = 6;
        for (int i=0;i<2;i++){
            s = new Coordinates(loc_chest, 0);
            CoinChest c_chest = new CoinChest(i+21, s, 50);
            loc_chest += 18; //second coin chest at 24
        }

        loc_chest = 18;
        for (int i=0;i<3;i++){
            //WeaponChest w_chest = new WeaponChest(loc_chest, s, "weapon");
        }

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

