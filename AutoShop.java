
import java.util.List;

public class AutoShop <T extends Car> implements Loadable<T>{
    public final int capacity;
    protected List<T> carsInShop; // Behöver checka att vi bara tar emot bilar
    private double x;
    private double y;
    protected String shoptype;
    private String shopImage;

    public AutoShop(int capacity, List<T> carsInShop, double x, double y, String shopImage) {
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            throw new IllegalArgumentException("Capacity must be > 0");
        }
        this.carsInShop = carsInShop;
        this.x = x;
        this.y = y;
        this.shoptype = String.valueOf(carsInShop.getClass());
        this.shopImage = shopImage;
    }
    public double getX() {return x;}
    public double getY() {return y;}
    public String getShopImage() {return shopImage;}
    @Override
    public int getCapacity() {return capacity;}
    @Override
    public void loadCar(T carToLoad) {
        if (carsInShop.size() < capacity) {
            {carsInShop.add(carToLoad);}}
        else{throw new IllegalArgumentException("Shop is full");}
    }
    protected T unLoadCar(T carToUnload)
        {carsInShop.remove(carToUnload);
        return carToUnload;
    }
    @Override
    public List<T> getCarsInLoad() {return carsInShop; }
}

