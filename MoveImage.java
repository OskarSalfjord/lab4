import java.awt.image.BufferedImage;

public interface MoveImage<T>{
    double getX();

    double getY();

    BufferedImage getImage();

    double getX(T vehicleOrAutoshop);
    double getY(T vehicleOrAutoshop);
    BufferedImage getImage(T vehicleOrAutoShop);
}
