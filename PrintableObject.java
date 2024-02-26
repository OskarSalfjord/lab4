import java.awt.image.BufferedImage;

public abstract class PrintableObject implements MoveImage {
    protected String imgAdress;
    public BufferedImage bufferedImage;
    double x;
    double y;
    protected PrintableObject(double x, double y) {
        this.x = x;
        this.y = y;
        this.bufferedImage = null;
        this.imgAdress = null;
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
    @Override
    public BufferedImage getBufferedImage() {return this.bufferedImage;}
    @Override
    public void setBufferedImage(BufferedImage img) {this.bufferedImage = img;}
}