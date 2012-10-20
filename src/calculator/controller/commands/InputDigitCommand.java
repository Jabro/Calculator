package calculator.controller.commands;

import calculator.model.Calculator;

public class InputDigitCommand extends InputCommand {

	public InputDigitCommand(Calculator calculator, int digit) {
		super(calculator, String.valueOf(digit));
	}
	
}
