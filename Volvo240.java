import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;
    private String volvoImage;
    
    public Volvo240(Color color, double x, double y, double direction) {
        super(4, color, 100, "Volvo240", 1200, x, y, direction);
        stopEngine();
        this.volvoImage = "pics/VolvoBrand.jpg";
    }
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }
}
