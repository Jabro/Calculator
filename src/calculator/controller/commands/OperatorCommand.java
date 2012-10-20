package calculator.controller.commands;

import calculator.model.Calculator;
import calculator.model.Operator;

public class OperatorCommand extends Command {

	private final Operator operator;
	private final Calculator calculator;

	public OperatorCommand(Calculator calculator, Operator operator) {
		super(operator.getSign());
		this.calculator = calculator;
		this.operator = operator;
	}

	@Override
	public void execute() {
		calculator.useOperator(operator);
	}
	
}
