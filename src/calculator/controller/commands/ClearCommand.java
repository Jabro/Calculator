package calculator.controller.commands;

import calculator.model.Calculator;

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
