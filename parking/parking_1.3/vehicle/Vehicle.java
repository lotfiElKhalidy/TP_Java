package vehicle;

class Vehicle {
    protected String IDlicense;

    // The constructor ganerates a random registration license for the new object
    public Vehicle() {
        double randomNumber = Math.random()*1000;
        int integerRand = (int) randomNumber;
        String randomID = "ID" + integerRand;
        setIDLincense(randomID);
    }

    public Vehicle(String IDlicense) {
        setIDLincense(IDlicense);
    }

    public String getIDLicense() {
        return IDlicense;
    }
    
    public void setIDLincense(String ID) {
        IDlicense = ID;
    }

    public void displayVehicle() {
        System.out.println("I'm a vehicle and my registration license is :" + getIDLicense());
    }

    public void moveVehicle() {
        System.out.println("I'm moving.");
    }
}