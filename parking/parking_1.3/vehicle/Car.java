package vehicle;

class Car extends Vehicle {
    private int color;
    private int seats;
    
    public Car() {
        super();
    }

    public Car(String IDlicense) {
        super(IDlicense);
    }

    @Override
    public void displayVehicle() {
        System.out.println("I'm a car and my registration license is :" + getIDLicense());
    }

    public void moveVehicle() {
        System.out.println("I'm moving.");
    }
}