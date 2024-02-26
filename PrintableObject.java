import java.awt.image.BufferedImage;
import java.util.List;

public abstract class PrintableObject implements MoveImage {
    private final String imgAdress;
    double x;
    double y;
    protected PrintableObject(String imgAdress, double x, double y) {
        this.imgAdress = imgAdress;
        this.x = x;
        this.y = y;
    }
    @Override
    public double getX(){
        return this.x;
    }
    @Override
    public double getY(){
        return this.y;
    }
    @Override
    public String getImage(){
        return this.imgAdress;
    }
}