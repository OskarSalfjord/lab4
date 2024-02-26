import java.awt.image.BufferedImage;

//Implementera i Vehicle och AutoShop så att det blir ett gemensamt gränssnitt i DrawPanel
public interface MoveImage {
    double getX();

    double getY();

    String getImage();

    BufferedImage getBufferedImage();

    void setBufferedImage(BufferedImage img);
}
