import java.util.ArrayList;

public class VehiclesAndShops {
    ArrayList<Vehicle> vehicles;
    ArrayList<AutoShop> shops;
    //ArrayList allitems;

    public VehiclesAndShops(ArrayList<Vehicle> vehicles, ArrayList<AutoShop> shops) {
        this.vehicles = vehicles;
        this.shops = shops;
        //this.allitems = allitems;
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
}
