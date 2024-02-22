import java.util.List;

public abstract class PrintableObject implements MoveImage {
    private final String img;
    double x;
    double y;
    protected PrintableObject(String img, double x, double y) {
        this.img = img;
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
        return this.img;
    }
}