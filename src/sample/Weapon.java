package sample;

abstract public class Weapon {
    private final String type;
    private int lastfor;
    private boolean WeaponActiveStatus;

    public Weapon(String t){
        type=t;
        WeaponActiveStatus=false;
        lastfor=2;
    }

    public int getLastfor() {
        return lastfor;
    }

    public String getType() {
        return type;
    }

    public void setLastfor(int lastfor) {
        this.lastfor = lastfor;
    }

    public void setWeaponActiveStatus(boolean weaponActiveStatus) {
        WeaponActiveStatus = weaponActiveStatus;
    }
    public boolean getWeaponActiveStatus(){
        return WeaponActiveStatus;
    }
    abstract public void useWeapon(double x);
}
