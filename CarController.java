import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();
    ArrayList<Volvo240> carsinshop1 = new ArrayList<>();
    AutoShop<Volvo240> volvoshop = new AutoShop<>(5, carsinshop1, 300, 300);

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(Color.BLUE, 0, 302, 0));
        cc.cars.add(new Saab95(Color.CYAN, 0, 200, 0));
        cc.cars.add(new Scania(Color.BLACK, 0, 300, 0));


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : cars) {
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
                        if ((Math.abs(vehicle.getX() - volvoshop.getX())) < 50 && Math.abs((vehicle.getY() - volvoshop.getY())) < 50) {
                            volvoshop.loadCar((Volvo240) vehicle);
                            vehicle.set_canMove(false);
                            frame.drawPanel.volvoImage = null;
                        }
                        else {
                        frame.drawPanel.moveitVolvo(x, y);
                        // repaint() calls the paintComponent method of the panel
                        frame.drawPanel.repaint();}
                    } else if (vehicle instanceof Saab95) {
                        frame.drawPanel.moveitSaab(x, y);
                        // repaint() calls the paintComponent method of the panel
                        frame.drawPanel.repaint();
                    } else if (vehicle instanceof Scania) {
                        frame.drawPanel.moveitScania(x, y);
                        frame.drawPanel.repaint();
                    }
                }
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.gas(gas);

        }
    }

    void startEngine() {
        for (Vehicle car : cars
        ) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Vehicle car : cars
        ) {
            car.stopEngine();
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.brake(brake);
        }
    }

    void turboOn() {
        for (Vehicle car : cars
        ) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }
    void turboOff() {
        for (Vehicle car : cars
        ) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }
    void raiseRamp() {
        for (Vehicle car : cars
        ) {
            if (car instanceof Scania) {
                ((Scania) car).raiseRamp();
            }
        }
    }
    void lowerRamp() {
        for (Vehicle car : cars
        ) {
            if (car instanceof Scania) {
                ((Scania) car).lowerRamp();
            }
        }
    }
}