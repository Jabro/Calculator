package calculator.model.calculation.strategies;

public abstract class BinaryCalculationStrategy implements CalculationStrategy{

	public final double calculate(double operand) {
		return calculate(operand, operand);
	}
	
	public final double calculate(double firstOperand, Double secondOperand) {
		return calculate(firstOperand, secondOperand.doubleValue());
	}
	
	protected abstract double calculate(double firstOperand, double secondOperand);
	
	
}
