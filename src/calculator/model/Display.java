package calculator.model;

import javax.swing.event.EventListenerList;

import calculator.model.events.DisplayChangedEvent;
import calculator.model.events.DisplayEventListener;

public class Display {

	private static final String INITIAL_VALUE = "0";
	private String content;
	private EventListenerList listeners = new EventListenerList();

	public Display() {
		clearDisplay();
	}

	public void clearDisplay() {
		setContent(INITIAL_VALUE);
	}

	public void addDigit(int digit) {
		addContent(String.valueOf(digit));
		System.out.println(content);		
	}

	private void setContent(String content) {
		this.content = content;
		raiseDisplayChangedEvent(new DisplayChangedEvent(this, content));
	}

	public void addContent(String suffix) {
		if(content.startsWith(INITIAL_VALUE)) {
			setContent(suffix);
		} else {
			setContent(content + suffix);
		}
	}

	public String getContent() {
		return content;
	}

	public void setDisplay(double result) {
		setContent(String.valueOf(result));
	}

	public void addListener(DisplayEventListener listener) {
		listeners .add(DisplayEventListener.class, listener);
	}

	public void removeListener(DisplayEventListener listener) {
		listeners.remove(DisplayEventListener.class, listener);
	}

	private void raiseDisplayChangedEvent(DisplayChangedEvent event) {
		for (DisplayEventListener listener : listeners.getListeners(DisplayEventListener.class)) {
			listener.onDisplayChanged(event);
		}
	}

	public double getNumber() {
		return Double.valueOf(content);
	}

}
