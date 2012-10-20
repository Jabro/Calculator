package calculator.controller.commands;

import calculator.model.Calculator;
import calculator.model.Operator;

public class OperatorCommand extends Command {

	private final Operator operator;

	public OperatorCommand(Calculator calculator, Operator operator) {
		super(calculator, operator.getSign());
		this.operator = operator;
	}

	@Override
	public void execute() {
		calculator.useOperator(operator);
	}
	
}
