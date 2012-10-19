package calculator.model.display;

public abstract class DisplayState {

	private static final String DEZIMAL_POINT = ".";

	protected enum States {
		CLEAR(ClearDisplayState.getInstance()),
		INTEGER(IntegerDisplayState.getInstance()),
		FLOATING_POINT(FloatingPointDisplayState.getInstance()),
		ERROR(ErrorDisplayState.getInstance());

		private final DisplayState state;

		private States(DisplayState state) {
			this.state = state;
		}

		public DisplayState getState() {
			return state;
		}

	}

	protected boolean isDezimalPoint(String input) {
		return input.equals(DEZIMAL_POINT);
	}

	public abstract void addContent(DisplayStateSupport display, String suffix);

}
