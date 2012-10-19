package calculator.controller.commands;

import calculator.model.pocket.calculator.PocketCalculator;

public class ClearCommand extends Command {

	private static final String CLEAR_SIGN = "C";

	public ClearCommand(PocketCalculator pocketCalculator) {
		super(pocketCalculator, CLEAR_SIGN);
	}

	@Override
	public void execute() {
		pocketCalculator.executeClear();
	}
	
}
