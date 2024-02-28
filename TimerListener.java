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
            // System.out.println("X= " + vehicle.getX());
            if (frame.getWindowWidth() - 100 < vehicle.getX()) {
                vehicle.setPosition(frame.getWindowWidth() - 100, vehicle.getY());
                vehicle.setDirection(vehicle.getDirection() - Math.PI);
                vehicle.stopEngine();
                vehicle.startEngine();
            //    System.out.println("Collision registered");
            } else if (vehicle.getX() < 0) {
                vehicle.setPosition(0, vehicle.getY());
                vehicle.setDirection(vehicle.getDirection() - Math.PI);
                vehicle.stopEngine();
                vehicle.startEngine();
            //    System.out.println("Collision registered");
            } else if (vehicle.get_canMove()) {
            //    System.out.println("We should move");
                vehicle.move();

                if (vehicle instanceof Volvo240) {
                    for (AutoShop<Car> shop : shops)
                        if (Math.abs(vehicle.getX() - shop.getX()) < 100 && Math.abs((vehicle.getY() - shop.getY())) < 100) {
                            shop.loadCar((Volvo240) vehicle);
                            vehicle.set_canMove(false);
                            vehicle.setBufferedImage(null);
                        }
                }
            }
        }
        manager.notifyMovement();
    }
}