abstract public class Weapon {
    private final String type;
    private int lastfor;
    private boolean WeaponActiveStatus;

    public Weapon(String t){
        type=t;
        WeaponActiveStatus=false;
        lastfor=10;
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
    abstract public void useWeapon();
}