package de.youngdevelopers.calculator.controller.commands;

import de.youngdevelopers.calculator.model.Calculator;

public class InputCommand extends Command {

	private final String value;
	private final Calculator calculator;

	public InputCommand(Calculator calculator, String name) {
		super(name);
		this.calculator = calculator;
		this.value = getName();		
	}
	
	public InputCommand(Calculator calculator, String name, String value) {
		super(name);
		this.calculator = calculator;
		this.value = value;		
	}

	@Override
	public void execute() {
		calculator.useInput(value);
	}
	
}
