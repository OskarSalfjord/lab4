import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimerListener implements ActionListener {

    VehiclesAndShops<MoveImage> vas;
    ArrayList<Vehicle> vehicles;

    ArrayList<PrintableObject> allItems;
    ArrayList<AutoShop> shops;

    ArrayList<Vehicle> vehiclesInShop = new ArrayList<>();
    CarView frame;
    private EventManager manager;
    // Detta ska bli carmodell med TimerListenern inuti enl. TA
    public TimerListener(VehiclesAndShops<MoveImage> vas, CarView frame, EventManager manager) {
        this.vehicles = vas.vehicles;
        this.shops = vas.shops;
        this.allItems = vas.allItems;
        this.frame = frame;
        this.manager = manager;
    }

    public void actionPerformed(ActionEvent e) {
        for (Vehicle vehicle : vehicles) {
            if (frame.getWindowWidth() - 100 < vehicle.getX()) {
                collisionManagement(vehicle, frame.getWindowWidth() - 100, vehicle.getY());
            } else if (vehicle.getX() < 0) {
                collisionManagement(vehicle, 0, vehicle.getY());
                vehicle.setPosition(0, vehicle.getY());
            } else if (vehicle.get_canMove()) {
                vehicle.move();
                frame.drawPanel.repaint();

                if (vehicle instanceof Volvo240) {
                    for (AutoShop<Car> shop : shops)
                        if (Math.abs(vehicle.getX() - shop.getX()) < 100 && Math.abs((vehicle.getY() - shop.getY())) < 100) {
                            loadCar(shop, vehicle);
                        }
                }
            }
        }
        manager.notifyMovement();
        if (!vehiclesInShop.isEmpty()) {
            for (Vehicle vehicle: vehiclesInShop) {
                vehicles.remove(vehicle);
                allItems.remove(vehicle);
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
        vehiclesInShop.add(vehicle);
    }





}
