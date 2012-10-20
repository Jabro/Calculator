package calculator.model.display.event;

import javax.swing.event.EventListenerList;

public class DisplayEventSupport {
	
	private EventListenerList listeners = new EventListenerList();
	
	public void addListener(DisplayEventListener listener) {
		listeners .add(DisplayEventListener.class, listener);
	}

	public void removeListener(DisplayEventListener listener) {
		listeners.remove(DisplayEventListener.class, listener);
	}
	
	protected void raiseDisplayChangedEvent(DisplayChangedEvent event) {
		for (DisplayEventListener listener : listeners.getListeners(DisplayEventListener.class)) {
			listener.onDisplayChanged(event);
		}
	}

}
