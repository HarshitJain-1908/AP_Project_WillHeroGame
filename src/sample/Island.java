package sample;

public class Island extends GameObjects {
    private Coordinates endCoord;

    public Island(int id, Coordinates c, Coordinates e){
        super(id,c);
        endCoord=e;


    }
}
