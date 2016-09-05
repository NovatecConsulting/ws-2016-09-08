package example.mocking.events;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EventSystem {

    private static final Logger log = LoggerFactory.getLogger(EventSystem.class);

    private List<EventListener> listeners = new ArrayList<>();

    public void register(EventListener listener) {
        listeners.add(listener);
    }

    public void notifyListeners(Event event) {
        listeners.forEach(listener -> {
            try {
                listener.eventOccurred(event);
            } catch (RuntimeException e) {
                log.warn("event listener threw exception", e);
            }
        });
    }

}
