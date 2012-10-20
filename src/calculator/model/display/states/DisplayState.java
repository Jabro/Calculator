package calculator.model.display.states;

public abstract class DisplayState {

	private static final String DEZIMAL_POINT = ".";

	protected boolean isDezimalPoint(String input) {
		return input.equals(DEZIMAL_POINT);
	}

	public abstract void addContent(DisplayStateSupport display, String suffix);

	public boolean isErrorState() {
		return false;
	}

}
