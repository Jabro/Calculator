package calculator.model;

import javax.swing.event.EventListenerList;

import calculator.model.events.DisplayChangedEvent;
import calculator.model.events.DisplayEventListener;

public class Display {

	private static final String YOU_DO_NOT_RESPECT_THE_WORKFLOW = "YOU DO NOT RESPECT THE WORKFLOW";
	private static final String DEZIMAL_POINT = ".";
	private static final String INITIAL_VALUE = "0";
	private String content;
	private EventListenerList listeners = new EventListenerList();
	private boolean isErrorState = false;
	private boolean isInteger = true;

	public Display() {
		clear();
	}

	public void clear() {
		isErrorState = false;
		isInteger = true;
		setContent(INITIAL_VALUE);
	}

	public void addDigit(int digit) {
		addContent(String.valueOf(digit));		
	}

	private void setContent(String content) {
		this.content = content;
		raiseDisplayChangedEvent(new DisplayChangedEvent(this, this));
	}

	public void addContent(String suffix) {
		isErrorState = false;
		if(!isDezimalPoint(suffix)) {
			if(isInitialDisplay()) {
				setContent(suffix);
			} else{
				setContent(content + suffix);
			}
		} else if(isInteger()) {
			isInteger = false;
			setContent(content + suffix);
		}
	}

	private boolean isInteger() {
		return isInteger ;
	}

	private boolean isInteger(Double number) {
		return number.intValue() == number;
	}

	public boolean isDezimalPoint(String input) {
		return input.equals(DEZIMAL_POINT);
	}

	public boolean isInitialDisplay() {
		return content.length() <= 1 && content.startsWith(INITIAL_VALUE);
	}

	public String getContent() {
		return content;
	}

	public void setNumber(Double number) {
		isInteger = isInteger(number);
		isErrorState = false;
		if(isInteger) {
			setContent(String.valueOf(number.intValue()));
		} else {		
			setContent(String.valueOf(number));
		}
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

	public void error() {
		isErrorState = true;
		setContent(YOU_DO_NOT_RESPECT_THE_WORKFLOW);		
	}

	public boolean isErrorMessage() {
		return isErrorState ;
	}

}
