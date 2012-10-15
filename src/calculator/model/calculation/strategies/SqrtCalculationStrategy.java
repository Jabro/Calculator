package calculator.model.calculation.strategies;

public class SqrtCalculationStrategy implements CalculationStrategy {

	@Override
	public double calculate(double firstOperand, double secondOperand) {
		return Math.sqrt(secondOperand);
	}

}
