package Model;

import java.awt.image.BufferedImage;

//Implementera i Model.Vehicle och Model.AutoShop så att det blir ett gemensamt gränssnitt i View.DrawPanel
public interface MoveImage {
    double getX();

    double getY();

    String getImage();

    BufferedImage getBufferedImage();

    void setBufferedImage(BufferedImage img);
}
