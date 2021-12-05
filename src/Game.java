import java.io.Serializable;
import java.util.LinkedList;

public class Game implements Serializable {
    private Player hero;
    private LinkedList<GameObjects> gameObjects;
    private static int highScore;
    private int gid;
    private static long serialVersionUID;

    public Game(){
        //System.out.println("Enter the name: ");

        hero = new Player("mickey");
        gameObjects = new LinkedList<>();

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
