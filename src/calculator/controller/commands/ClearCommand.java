package calculator.controller.commands;

import calculator.model.Calculator;

public class ClearCommand extends Command {

	private static final String CLEAR_SIGN = "C";

	public ClearCommand(Calculator calculator) {
		super(calculator, CLEAR_SIGN);
	}

	@Override
	public void execute() {
		calculator.executeClear();
	}
	
}
