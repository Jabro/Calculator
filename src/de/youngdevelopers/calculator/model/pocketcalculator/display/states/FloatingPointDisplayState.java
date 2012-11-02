package de.youngdevelopers.calculator.model.pocketcalculator.display.states;

public final class FloatingPointDisplayState extends DisplayState {

	private static FloatingPointDisplayState instance;

	public static FloatingPointDisplayState getInstance() {
		if(instance == null) {
			instance = new FloatingPointDisplayState();
		}
		return instance;
	}

	private FloatingPointDisplayState() {
	}

	@Override
	public void addContent(DisplayStateSupport display, String suffix) {
		if(isDezimalPoint(suffix)) {
			return;
		}
		addDigit(display, suffix);
	}

	private void addDigit(DisplayStateSupport display, String digit) {
		display.setContent(display.getContent() +  digit);
	}

}
