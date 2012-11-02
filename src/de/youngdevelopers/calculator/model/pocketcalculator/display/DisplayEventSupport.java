package de.youngdevelopers.calculator.model.pocketcalculator.display;

import javax.swing.event.EventListenerList;

import de.youngdevelopers.calculator.model.DisplayChangedEvent;
import de.youngdevelopers.calculator.model.DisplayEventListener;

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
