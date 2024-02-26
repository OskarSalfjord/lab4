import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimerListener implements ActionListener {
    ArrayList<Vehicle> vehicles;
    ArrayList<AutoShop<Car>> shops;
    CarView frame;

    public TimerListener(ArrayList<Vehicle> vehicles, ArrayList<AutoShop<Car>> shops) {
    this.vehicles = vehicles;
    this.shops = shops;
}
    public void actionPerformed(ActionEvent e) {
        for (Vehicle vehicle : vehicles) {
            if (frame.getWindowWidth() - 100 < vehicle.getX()) {
                vehicle.setPosition(frame.getWindowWidth() - 100, vehicle.getY());
                vehicle.setDirection(vehicle.getDirection() - Math.PI);
                vehicle.stopEngine();
                vehicle.startEngine();
            } else if (vehicle.getX() < 0) {
                vehicle.setPosition(0, vehicle.getY());
                vehicle.setDirection(vehicle.getDirection() - Math.PI);
                vehicle.stopEngine();
                vehicle.startEngine();
            } else if (vehicle.get_canMove()) {
                vehicle.move();
                frame.drawPanel.repaint();

//                if (vehicle instanceof Volvo240) {
//                    for (AutoShop<Car> shop : shops)
//                    if ((shop instanceof AutoShop<Volvo240>) && (Math.abs(vehicle.getX() - shop.getX())) < 50 && Math.abs((vehicle.getY() - shop.getY())) < 50) {
//                        shop.loadCar((Volvo240) vehicle);
//                        vehicle.set_canMove(false);
//                        //frame.drawPanel.volvoImage = null;
                }
            }
        }
    }
