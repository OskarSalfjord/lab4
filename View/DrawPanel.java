package View;

import Model.MoveImage;
import Model.PrintableObject;
import Model.Subscriber;
import Model.VehiclesAndShops;

import java.awt.*;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.
// Byt namn på Carview, View.DrawPanel. Drawpanel är vår modell som bör ha en carview, inte tvärtom
public class DrawPanel extends JPanel implements Subscriber {

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
            // volvoImage = ImageIO.read(new File("Model.Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
           for (MoveImage printable : vas.allItems) {
                   String s = printable.getImage();
                   printable.setBufferedImage(ImageIO.read(DrawPanel.class.getResourceAsStream(s)));
               }


//            volvoImage =
//            volvoWorkshopImage = ImageIO.read(View.DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
//            saabImage = ImageIO.read(View.DrawPanel.class.getResourceAsStream("pics/Model.Saab95.jpg"));
//            scaniaImage = ImageIO.read(View.DrawPanel.class.getResourceAsStream("pics/Model.Scania.jpg"));
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
            g.drawImage(printable.getBufferedImage(), (int) Math.round(printable.getX()), (int) Math.round(printable.getY()), null);
        }
        try {
            if (!vas.newObjects.isEmpty()) {
                Iterator<PrintableObject>iterator = vas.newObjects.iterator();
            while (iterator.hasNext()) {
                PrintableObject newobj = iterator.next();
                iterator.remove();
                newobj.setBufferedImage(ImageIO.read(DrawPanel.class.getResourceAsStream(newobj.getImage())));
                ;// Remove the current element using the iterator
            }}
        } catch (IOException ex) {
            ex.printStackTrace();


        }
    }
    @Override
    public void updatePosition() {
        super.repaint();
    }
}
