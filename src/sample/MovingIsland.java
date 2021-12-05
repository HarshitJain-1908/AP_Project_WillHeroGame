package sample;

public class MovingIsland extends Island {
    private float speed;

    public MovingIsland(int id, Coordinates c, Coordinates e) {
        super(id, c, e);
        speed=2;
    }
}
