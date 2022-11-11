import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;

public class Parking {
    public static void main(String[] argv) {
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