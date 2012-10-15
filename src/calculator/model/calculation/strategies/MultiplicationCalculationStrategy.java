package calculator.model.calculation.strategies;

public class MultiplicationCalculationStrategy extends BinaryCalculationStrategy {

	@Override
	public double calculate(double firstOperand, double secondOperand) {
		return firstOperand * secondOperand;
	}

}
