package sample;

abstract public class Orc extends GameObjects {
    private int power;
    private final int size;
    private int reward;
    private final String type;
    private final int jumpHeight;

    public Orc(int id, Coordinates c, String t, int s, int p, int r){
        super(id,c);
        jumpHeight=2;
        type=t;
        size=s;
        power=p;
        reward=r;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public int getPower() {
        return power;
    }

    public int getReward() {
        return reward;
    }

    public int getSize() {
        return size;
    }
    public void jump(){

    }
    @Override
    public void slide(){

    }
    abstract public void killHero();
}