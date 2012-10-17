package calculator.model.calculation.strategies;

public class MinusCalculationStrategy extends BinaryCalculationStrategy {

	private static CalculationStrategy instance;

	public static CalculationStrategy getInstance() {
		if(instance == null) {
			instance = new MinusCalculationStrategy();
		}
		return instance;
	}
	
	private MinusCalculationStrategy() {
	}
	
	@Override
	public double calculate(double firstOperand, double secondOperand) {
		return firstOperand - secondOperand;
	}


}
