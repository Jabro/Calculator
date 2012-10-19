package calculator.controller.commands;

import calculator.model.PocketCalculator;

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
