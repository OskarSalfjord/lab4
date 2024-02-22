import java.awt.*;

public abstract class Truck extends Vehicle {
    private final int nrDoors;
    public Truck(int nrDoors, Color color, double enginePower, String modelName, double weight, double x, double y, double direction, String truckImage) {
        super(color, enginePower, modelName, weight, x, y, direction, truckImage);
        this.nrDoors = nrDoors;

    }
}
