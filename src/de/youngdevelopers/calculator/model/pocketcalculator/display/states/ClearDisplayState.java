package de.youngdevelopers.calculator.model.pocketcalculator.display.states;

public final class ClearDisplayState extends DisplayState {

	private static ClearDisplayState instance;

	public static ClearDisplayState getInstance() {
		if(instance == null) {
			instance = new ClearDisplayState();
		}
		return instance;
	}
	
	private ClearDisplayState() {
	}

	@Override
	public void addContent(DisplayStateSupport display, String suffix) {
		if(display.isInitialValue(suffix)) {
			return;
		}
		if(isDezimalPoint(suffix)) {
			setDezimalPoint(display, suffix);
		} else {
			setDigit(display, suffix);
		}
	}

	private void setDezimalPoint(DisplayStateSupport display, String suffix) {
		display.setState(FloatingPointDisplayState.getInstance());
		display.setContent(DisplayStateSupport.INITIAL_VALUE + suffix);
	}

	private void setDigit(DisplayStateSupport display, String suffix) {
		display.setState(IntegerDisplayState.getInstance());
		display.setContent(suffix);
	}

}
