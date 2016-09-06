package example.mocking.events;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.InOrder;


public class EventSystemTest { // Spy / Mock

    EventSystem cut = new EventSystem();

    @Test
    public void eventListenersAreInvokedInOrderOfRegistration() {

        EventListener listener1 = mock(EventListener.class);
        EventListener listener2 = mock(EventListener.class);
        EventListener listener3 = mock(EventListener.class);
        cut.register(listener2);
        cut.register(listener3);
        cut.register(listener1);

        Event event = mock(Event.class);
        cut.notifyListeners(event);

        InOrder inOrder = inOrder(listener1, listener2, listener3);
        inOrder.verify(listener2).eventOccurred(event);
        inOrder.verify(listener3).eventOccurred(event);
        inOrder.verify(listener1).eventOccurred(event);
        inOrder.verifyNoMoreInteractions();

    }

    @Test
    public void eventListenerExceptionsAreIgnored() {

        EventListener listener1 = mock(EventListener.class);
        EventListener listener2 = mock(EventListener.class);
        cut.register(listener1);
        cut.register(listener2);

        doThrow(RuntimeException.class).when(listener1).eventOccurred(any(Event.class));

        Event event = mock(Event.class);
        cut.notifyListeners(event); // should not throw an exception!

        verify(listener1).eventOccurred(event);
        verify(listener2).eventOccurred(event);

    }

}
