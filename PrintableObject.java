public abstract class PrintableObject implements MoveImage{
    private final String img;
    double x;
    double y;


    protected PrintableObject(String img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }
}
