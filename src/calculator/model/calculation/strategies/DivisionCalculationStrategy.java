package calculator.model.calculation.strategies;

public class DivisionCalculationStrategy extends BinaryCalculationStrategy {

	@Override
	public double calculate(double firstOperand, double secondOperand) {
		return firstOperand / secondOperand;
	}

}
