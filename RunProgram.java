import javax.swing.*;
import java.awt.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class RunProgram {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    private VehiclesAndShops vas = new VehiclesAndShops();
    //private CarView view = new CarView("CarSim 1.1");



    public static void main(String[] args) {
        // Instance of this class

        cc.cars.add(new Volvo240(Color.BLUE, 0, 302, 0));
        cc.cars.add(new Saab95(Color.CYAN, 0, 200, 0));
        cc.cars.add(new Scania(Color.BLACK, 0, 300, 0));


        // Start a new view and send a reference of self
        CarView view = new CarView("CarSim 1.1");

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */


    // Calls the gas method for each car once

}