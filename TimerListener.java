import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimerListener implements ActionListener {
    ArrayList<Vehicle> vehicles;
    AutoShop<Car> volvoShop;
    CarView frame;
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
                int x = (int) Math.round(vehicle.getX());
                int y = (int) Math.round(vehicle.getY());

                if (vehicle instanceof Volvo240) {
                    if ((Math.abs(vehicle.getX() - volvoShop.getX())) < 50 && Math.abs((vehicle.getY() - volvoShop.getY())) < 50) {
                        volvoShop.loadCar((Volvo240) vehicle);
                        vehicle.set_canMove(false);
                        frame.drawPanel.volvoImage = null;
                    }
                    else {
                        frame.drawPanel.moveItGeneral(vehicle, x, y);
                        frame.drawPanel.moveitVolvo(x, y);
                        // repaint() calls the paintComponent method of the panel
                        frame.drawPanel.repaint();}
                } else if (vehicle instanceof Saab95) {
                    frame.drawPanel.moveItGeneral(vehicle, x, y);
                    frame.drawPanel.moveitSaab(x, y);
                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();
                } else if (vehicle instanceof Scania) {
                    frame.drawPanel.moveItGeneral(vehicle, x, y);
                    frame.drawPanel.moveitScania(x, y);
                    frame.drawPanel.repaint();
                }
            }
        }
    }
}
