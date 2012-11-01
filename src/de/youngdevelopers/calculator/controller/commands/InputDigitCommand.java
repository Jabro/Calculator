package de.youngdevelopers.calculator.controller.commands;

import de.youngdevelopers.calculator.model.Calculator;

public class InputDigitCommand extends InputCommand {

	public InputDigitCommand(Calculator calculator, int digit) {
		super(calculator, String.valueOf(digit));
	}
	
}
