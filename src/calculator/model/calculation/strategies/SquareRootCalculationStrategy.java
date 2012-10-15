package calculator.model.calculation.strategies;

public class SquareRootCalculationStrategy extends UnaryCalculationStrategy {

	@Override
	public double calculate(double operand) {
		return Math.sqrt(operand);
	}

}
