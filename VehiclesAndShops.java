import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class VehiclesAndShops <T extends MoveImage> {
    ArrayList<Vehicle> vehicles;
    ArrayList<AutoShop> shops;
    ArrayList<PrintableObject> allItems;
    VehiclesCreator creator;
    ArrayList<PrintableObject> newObjects;
    private EventManager manageMovement;

    public VehiclesAndShops(ArrayList<Vehicle> vehicles, ArrayList<AutoShop> shops, VehiclesCreator creator) {
        this.vehicles = vehicles;
        this.shops = shops;
        ArrayList<PrintableObject> allItems = new ArrayList<>();
        allItems.addAll(vehicles);
        allItems.addAll(shops);
        this.allItems = allItems;
        this.newObjects = new ArrayList<>();
        this.creator = creator;

    }
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : vehicles
        ) {
            car.gas(gas);
        }
    }
    void startEngine() {
        for (Vehicle car : vehicles
        ) {
            car.startEngine();
        }
    }
    void stopEngine() {
        for (Vehicle car : vehicles
        ) {
            car.stopEngine();
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : vehicles
        ) {
            car.brake(brake);
        }
    }
    void turboOn() {
        for (Vehicle car : vehicles
        ) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }
    void turboOff() {
        for (Vehicle car : vehicles
        ) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }
    void raiseRamp() {
        for (Vehicle car : vehicles
        ) {
            if (car instanceof Scania) {
                ((Scania) car).raiseRamp();
            }
        }
    }
    void lowerRamp() {
        for (Vehicle car : vehicles
        ) {
            if (car instanceof Scania) {
                ((Scania) car).lowerRamp();
            }
        }
    }
    void removeCar() {
        if (!vehicles.isEmpty()) {
            vehicles.getFirst().setBufferedImage(null);
            vehicles.removeFirst();
        }
    }
    void addCar() {
        Vehicle vehicle = creator.createVolvo240(Color.BLACK, 0,0,0);
        this.vehicles.add(vehicle);
        this.allItems.add(vehicle);
        this.newObjects.add(vehicle);
        System.out.println("button pressed");
    }
}

