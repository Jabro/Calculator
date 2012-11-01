package de.youngdevelopers.calculator.controller.commands;

import de.youngdevelopers.calculator.model.Calculator;

public class CalculateCommand extends Command {

	private static final String EQUAL_SIGN = "=";
	private final Calculator calculator;

	public CalculateCommand(Calculator calculator) {
		super(EQUAL_SIGN);
		this.calculator = calculator;
	}

	@Override
	public void execute() {
		calculator.calculateFromEqualSign();
	}
	
}
