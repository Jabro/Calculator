package calculator.view.events;

import java.util.EventObject;

import calculator.controller.InputValue;

public class InputEnteredEvent extends EventObject {
	
	private static final long serialVersionUID = 121221228930754137L;
	private final InputValue input;

	
	public InputEnteredEvent(Object source, InputValue input) {
		super(source);
		this.input = input;
	}

	public InputValue getInput() {
		return input;
	}
	
}

