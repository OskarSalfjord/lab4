import java.awt.image.BufferedImage;

public interface MoveImage<T>{
    double getX(T vehicleOrAutoshop);
    double getY(T vehicleOrAutoshop);
    BufferedImage getImage(T vehicleOrAutoShop);
}
