package calculator.controller.commands;

import calculator.model.Operator;
import calculator.model.pocket.calculator.PocketCalculator;

public class OperatorCommand extends Command {

	private final Operator operator;

	public OperatorCommand(PocketCalculator pocketCalculator, Operator operator) {
		super(pocketCalculator, operator.getSign());
		this.operator = operator;
	}

	@Override
	public void execute() {
		pocketCalculator.useOperator(operator);
	}
	
}
