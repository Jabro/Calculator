package calculator.controller.commands;

import calculator.model.Calculator;

public class CalculateCommand extends Command {

	private static final String EQUAL_SIGN = "=";

	public CalculateCommand(Calculator calculator) {
		super(calculator, EQUAL_SIGN);
	}

	@Override
	public void execute() {
		calculator.calculateFromEqualSign();
	}
	
}
