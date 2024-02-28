import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Subscriber> listeners = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        listeners.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        listeners.remove(subscriber);
    }

    public void notifyMovement() {
        for (Subscriber subscriber: listeners) {
            subscriber.updatePosition();
        }
    }
}