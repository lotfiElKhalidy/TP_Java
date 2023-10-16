abstract class Weapon {
    private int  serialNumber;
    
    public Weapon() {
        System.out.println("----------------------------------");
        System.out.println("Weapon's constructor");
        
        int random = (int) Math.random()*101
        setSerialNumber(random); 
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumberVar) {
        serialNumber = serialNumberVar;
    }

    public void displayWeapon() {
        System.out.println("This is a Weapon's object");
    }
}