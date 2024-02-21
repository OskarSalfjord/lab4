import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class RunProgram {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    protected final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    //private Timer timer = new Timer(delay, new TimerListener());


    public static void main(String[] args) {
        // Instance of this class
        RunProgram rp = new RunProgram();
        int delay = rp.delay;
        ArrayList<Vehicle> allVehicles = new ArrayList<>();
        ArrayList<Volvo240> volvoList1 = new ArrayList<>();
        ArrayList<Vehicle> allCarsList1 = new ArrayList<>();

        allCarsList1.add(new Volvo240(Color.BLUE, 0, 302, 0));
        allCarsList1.add(new Saab95(Color.CYAN, 0, 200, 0));
        allCarsList1.add(new Scania(Color.BLACK, 0, 300, 0));

        ArrayList<AutoShop> allShops = new ArrayList<>();
        AutoShop volvoshop1 = new AutoShop(5, volvoList1, 100, 100, "pics/VolvoBrand.jpg");
        allShops.add(volvoshop1);


        // Start a new view and send a reference of self
        CarView view = new CarView("CarSim 1.1");
        VehiclesAndShops vas = new VehiclesAndShops(allVehicles, allShops);
        ButtonController bc = new ButtonController(view, vas);
        Timer timer = new Timer(delay, new TimerListener(allVehicles, allShops));

        // Start the timer
        timer.start();

    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */


    // Calls the gas method for each car once

}