import Controller.ButtonController;
import Model.*;
import View.CarView;
import View.DrawPanel;
import Model.EventManager;

import java.awt.*;
import java.util.ArrayList;

public class RunProgram {
    public static void main(String[] args) {
        EventManager manager = new EventManager();
        ArrayList<Vehicle> allVehicles = new ArrayList<>();
        ArrayList<Volvo240> volvoList1 = new ArrayList<>();

        VehiclesCreator v = new VehiclesCreator();

        allVehicles.add(v.createVolvo240(Color.BLACK, 0 , 0, 0));
        allVehicles.add(v.createSaab95(Color.yellow, 100, 100, 0));
        allVehicles.add(v.createScania(Color.blue, 200 , 100, 0));
        allVehicles.add(v.createVolvo240(Color.CYAN, 0, 300, 0));

        ArrayList<AutoShop<Car>>allShops = new ArrayList<>();
        AutoShop<Car> volvoshop1 = new AutoShop(5, volvoList1, 200, 300, "../pics/VolvoBrand.jpg");
        allShops.add(volvoshop1);

        // Start a new view and send a reference of self
        VehiclesAndShops<MoveImage> vas = new VehiclesAndShops(allVehicles, allShops, v);
        DrawPanel drawPanel = new DrawPanel(800, 560, vas);
        CarView view = new CarView("CarSim 1.1");

        view.add(drawPanel);

        manager.subscribe(drawPanel);
        ButtonController bc = new ButtonController(view, vas);
        CarModell carModell = new CarModell(vas, manager);
    }

}