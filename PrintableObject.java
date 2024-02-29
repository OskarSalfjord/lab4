import java.awt.image.BufferedImage;

public abstract class PrintableObject implements MoveImage {
    protected String imgAdress;
    private BufferedImage bufferedImage;
    protected double x;
    protected double y;
    protected PrintableObject(double x, double y) {
        this.x = x;
        this.y = y;
        this.bufferedImage = null;
        this.imgAdress = null;
    }
    @Override
    public double getX(){
        return x;
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