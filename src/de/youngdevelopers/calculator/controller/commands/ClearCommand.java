package de.youngdevelopers.calculator.controller.commands;

import de.youngdevelopers.calculator.model.Calculator;

public class ClearCommand extends Command {

	private static final String CLEAR_SIGN = "C";
	private final Calculator calculator;

	public ClearCommand(Calculator calculator) {
		super(CLEAR_SIGN);
		this.calculator = calculator;
	}

	@Override
	public void execute() {
		calculator.executeClear();
	}
	
}
