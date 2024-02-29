package Model;

import Model.Car;

import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;
    
    public Volvo240(Color color, double x, double y, double direction) {
        super(4, color, 100, "Volvo240", 1200, x, y, direction);
        stopEngine();
        this.imgAdress = "../pics/Volvo240.jpg";
    }
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

//    @Override
//    public Model.PrintableObject create(Color color, double x, double y, double direction) {
//        return c.create(color, x, y, direction);
    }



