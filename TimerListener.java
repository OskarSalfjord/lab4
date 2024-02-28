import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimerListener implements ActionListener {
    ArrayList<Vehicle> vehicles;
    ArrayList<AutoShop<Car>> shops;
    CarView frame;
    private EventManager manager;
    // Detta ska bli carmodell med TimerListenern inuti enl. TA
    public TimerListener(ArrayList<Vehicle> vehicles, ArrayList<AutoShop<Car>> shops, CarView frame, EventManager manager) {
        this.vehicles = vehicles;
        this.shops = shops;
        this.frame = frame;
        this.manager = manager;
    }

    public void actionPerformed(ActionEvent e) {
        for (Vehicle vehicle : vehicles) {
            if (frame.getWindowWidth() - 100 < vehicle.getX()) {
                collisonManagement(vehicle, frame.getWindowWidth() - 100, vehicle.getY());
            } else if (vehicle.getX() < 0) {
                collisonManagement(vehicle, 0, vehicle.getY());
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
    }
    private void collisonManagement(Vehicle vehicle, double x, double y) {
        vehicle.setPosition(x, y);
        vehicle.setDirection(vehicle.getDirection() - Math.PI);
        vehicle.stopEngine();
        vehicle.startEngine();
    }

    private void loadCar(AutoShop<Car> shop, Vehicle vehicle) {
        shop.loadCar((Car) vehicle);
        vehicle.set_canMove(false);
        vehicle.setBufferedImage(null);
    }





}
