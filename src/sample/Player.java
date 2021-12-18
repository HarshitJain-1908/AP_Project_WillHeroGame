package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Player {
    private int numberOfMoves;
    private final int jumpHeight;
    private final int moveLength;
    private int coins;
    private Helmet h;
    private Coordinates coord;
    private String name;
    private Game game;

    @FXML
    private ImageView me,movebutton;


    public Player(String s) {
        jumpHeight = 1;
        moveLength = 1;
        coins = 0;
        coord=new Coordinates(0,0);
        name=s;
        numberOfMoves=0;
        h=new Helmet();
    }
    public void jump(){

    }
    public void moveForward(){

    }
    public String getName() {
        return name;
    }

    public Helmet getH() {
        return h;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public int getMoveLength() {
        return moveLength;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setCoord(float x, float y) {
        coord.setX(x);
        coord.setY(y);
    }
    public void enterMenu(){

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
    public void CollideGameObject(GameObjects obj){

    }
}
