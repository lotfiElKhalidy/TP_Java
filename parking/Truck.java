class Truck extends Vehicle {
    private double capacity; 
    
    public Truck() {
        super();
    }

    public Truck(String IDlicense) {
        super(IDlicense);
    }

    @Override
    public void displayVehicle() {
        System.out.println("I'm a truck and my registration license is :" + getIDLicense());
    }

    public void moveVehicle() {
        System.out.println("I'm moving.");
    }
}