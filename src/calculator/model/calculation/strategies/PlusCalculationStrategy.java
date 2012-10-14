package calculator.model.calculation.strategies;

public class PlusCalculationStrategy implements CalculationStrategy {

	@Override
	public double calculate(double firstOperand, double secondOperand) {
		return firstOperand + secondOperand;
	}

}
