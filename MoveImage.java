import java.awt.image.BufferedImage;

public interface MoveImage {
    double getX();

    double getX(Object carOrShop);

    double getY();

    double getY(Object carOrShop);

    BufferedImage getImage();
}
