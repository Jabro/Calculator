package calculator.controller.commands;

import calculator.model.pocket.calculator.PocketCalculator;

public class CalculateCommand extends Command {

	private static final String EQUAL_SIGN = "=";

	public CalculateCommand(PocketCalculator pocketCalculator) {
		super(pocketCalculator, EQUAL_SIGN);
	}

	@Override
	public void execute() {
		pocketCalculator.calculateFromEqualSign();
	}
	
}
