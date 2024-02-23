import java.util.List;

public class EventManager {
    private List<Subscribers> listeners;

    public void subscribe(Subscribers subscriber) {
        listeners.add(subscriber);
    }

    public void unsubscribe(Subscribers subscriber) {
        listeners.remove(subscriber);
    }

    public void notifyMovement(Vehicle movedVehicle, double x, double y) {
        for (Subscribers subscriber: listeners) {
            subscriber.updatePosition(movedVehicle, x, y);
        }
    }
}