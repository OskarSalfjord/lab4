import java.util.List;

public class Publisher {
    private List<Subscribers> listeners;

    public void subscribe(Subscribers subscriber) {
        listeners.add(subscriber);
    }

    public void unsubscribe(Subscribers subscriber) {
        listeners.remove(subscriber);
    }

    public void notify(Object data) { // Byt ut Object inom sinom tid
        for (Subscribers subscriber: listeners) {
            subscriber.update(data);
        }
    }
}