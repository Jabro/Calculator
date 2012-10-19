package calculator.model.display;

public class ErrorDisplayState extends DisplayState {

	private static DisplayState instance;

	public static DisplayState getInstance() {
		if(instance == null) {
			instance = new ErrorDisplayState();
		}
		return instance;
	}
	
	private ErrorDisplayState() {
	}

	@Override
	public void addContent(DisplayStateSupport display, String suffix) {
		if(display.isInitialValue(suffix)) {
			display.setState(States.CLEAR);
			display.setContent(DisplayStateSupport.INITIAL_VALUE);
		}
		if(!isDezimalPoint(suffix)) {
			display.setState(States.INTEGER);
			display.setContent(suffix);
		} else {
			display.setState(States.FLOATING_POINT);
			display.setContent(DisplayStateSupport.INITIAL_VALUE + suffix);
		}
	}

}
