package Model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class CarModell {

    private final int windowX = 800;
    private final int windowY = 800;
    protected final int delay = 50;
    VehiclesAndShops<MoveImage> vas;
    EventManager manager;
    Timer timer;

    ArrayList<PrintableObject> allItems;

    ArrayList<Vehicle> vehicleInShop = new ArrayList<>();



    public CarModell(VehiclesAndShops<MoveImage> vas, EventManager manager) {
        this.vas = vas;
        this.manager = manager;
        this.timer = new Timer(delay, new TimerListener(vas, manager));
        timer.start();
        this.allItems = vas.allItems;

    }
    private class TimerListener implements ActionListener {
        VehiclesAndShops<MoveImage> vas;
        ArrayList<Vehicle> vehicles;
        ArrayList<AutoShop> shops;

        private EventManager manager;
        // Detta ska bli carmodell med TimerListenern inuti enl. TA
        public TimerListener(VehiclesAndShops vas, EventManager manager) {
            this.vas = vas;
            this.manager = manager;
            this.vehicles = vas.vehicles;
            this.shops = vas.shops;

        }
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                if (windowX - 100 < vehicle.getX()) {
                    collisionManagement(vehicle, windowX - 100, vehicle.getY());
                } else if (vehicle.getX() < 0) {
                    collisionManagement(vehicle, 0, vehicle.getY());
                    vehicle.setPosition(0, vehicle.getY());
                } else if (vehicle.get_canMove()) {
                    vehicle.move();
                //    frame.drawPanel.repaint();

                    if (vehicle instanceof Volvo240) {
                        for (AutoShop<Car> shop : shops)
                            if (Math.abs(vehicle.getX() - shop.getX()) < 100 && Math.abs((vehicle.getY() - shop.getY())) < 100) {
                                loadCar(shop, vehicle);
                            }
                    }
                }
            }
            manager.notifyMovement();
            if(!vehicleInShop.isEmpty());{
                for(Vehicle vehicle: vehicleInShop) {
                    vehicles.remove(vehicle);
                    allItems.remove(vehicle);
                }
            }

        }
    }
    private void collisionManagement(Vehicle vehicle, double x, double y) {
        vehicle.setPosition(x, y);
        vehicle.setDirection(vehicle.getDirection() - Math.PI);
        vehicle.stopEngine();
        vehicle.startEngine();
    }

    private void loadCar(AutoShop<Car> shop, Vehicle vehicle) {
        shop.loadCar((Car) vehicle);
        vehicle.setBufferedImage(null);
        vehicleInShop.add(vehicle);
    }
}

