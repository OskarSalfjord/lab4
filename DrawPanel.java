import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel implements Subscribers {

    // Just a single image, TODO: Generalize
    VehiclesAndShops<MoveImage> vas;
    // TODO: Make this general for all cars

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, VehiclesAndShops<MoveImage> vas) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        this.vas = vas;
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
           for (MoveImage printable : vas.allItems) {
               printable.setBufferedImage(ImageIO.read(DrawPanel.class.getResourceAsStream(printable.getImage())));
           }


//            volvoImage =
//            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
//            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
//            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (PrintableObject printable : vas.allItems) {
              g.drawImage(printable.getBufferedImage(), (int)Math.round(printable.getX()), (int)Math.round(printable.getY()), null);
        }
    }

    @Override
    public void updatePosition(Vehicle movedVehicle, double x, double y) {

    }
}
