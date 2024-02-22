import java.util.ArrayList;

public class VehiclesAndShops implements MoveImage{
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
    @Override
    public double getX(Object carOrShop) {
        if (carOrShop instanceof AutoShop<?>) {
            if (shops.contains(carOrShop)) {
                return ((AutoShop<?>) carOrShop).getX();
            }
            else {
                throw new IllegalArgumentException("This shop does not exist in the program");
            }
        }
        if (carOrShop instanceof Vehicle) {
            if (vehicles.contains(carOrShop)) {
                return ((Vehicle) carOrShop).getX();
            }
            else {
                throw new IllegalArgumentException("This vehicle does not exist in the program");
            }
        }
        else {
            throw new IllegalArgumentException("The method only accepts cars and shops as argument");
        }
    }

    @Override
    public double getY(Object carOrShop) {
        if (carOrShop instanceof AutoShop<?>) {
            if (shops.contains(carOrShop)) {
                return ((AutoShop<?>) carOrShop).getY();
            }
            else {
                throw new IllegalArgumentException("This shop does not exist in the program");
            }
        }
        if (carOrShop instanceof Vehicle) {
            if (vehicles.contains(carOrShop)) {
                return ((Vehicle) carOrShop).getY();
            }
            else {
                throw new IllegalArgumentException("This vehicle does not exist in the program");
            }
        }
        else {
            throw new IllegalArgumentException("The method only accepts cars and shops as argument");
        }
    }

    public String getImage(Object carOrShop) {
        if (carOrShop instanceof AutoShop<?>) {
            if (shops.contains(carOrShop)) {
                return ((AutoShop<?>) carOrShop).getShopImage();
            }
            else {
                throw new IllegalArgumentException("This shop does not exist in the program");
            }
        }
        if (carOrShop instanceof Vehicle) {
            if (vehicles.contains(carOrShop)) {
                return ((Vehicle) carOrShop).getImg();
            }
            else {
                throw new IllegalArgumentException("This vehicle does not exist in the program");
            }
        }
        else {
            throw new IllegalArgumentException("The method only accepts cars and shops as argument");
        }
        return null;
    }
}
