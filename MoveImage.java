import java.awt.image.BufferedImage;

public interface MoveImage<T>{
    double getX(T carOrShop);
    double getY(T carOrShop);
    BufferedImage getImage(T carOrShop);
}
