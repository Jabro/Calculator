package calculator.controller;

import java.util.Collection;

public interface CalculatorController {

	public Collection<Command> getCommands();

	public Collection<InputValue> getInputValues();
	
}
