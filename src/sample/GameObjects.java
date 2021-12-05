package sample;

abstract public class GameObjects {
    private Coordinates coord;
    private int id;

    public GameObjects(int id, Coordinates c){
        coord=c;
        this.id=id;
    }

    public int getId() {
        return id;
    }
    public void slide(){

    }
    @Override
    public boolean equals(Object o) {
        if (this.getClass() == o.getClass()) {
            GameObjects obj = (GameObjects) o;
            return this.id == obj.id;
        } else {
            return false;
        }
    }
}
