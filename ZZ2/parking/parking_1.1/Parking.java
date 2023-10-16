public class Parking
{
    public static void main(String[] argv)
    {
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle("ID5555");
        
        Car car1 = new Car();
        Car car2 = new Car("ID582");
        
        Truck truck1 = new Truck();
        Truck truck2 = new Truck("ID3286");
        
        vehicle1.displayVehicle();
        vehicle2.displayVehicle();

        car1.displayVehicle();
        car2.displayVehicle();

        truck1.displayVehicle();
        truck2.displayVehicle();
    }
}

class Car extends Vehicle{
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