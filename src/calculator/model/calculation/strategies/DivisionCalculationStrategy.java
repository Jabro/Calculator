package calculator.model.calculation.strategies;

public class DivisionCalculationStrategy extends BinaryCalculationStrategy {

	private static CalculationStrategy instance;

	public static CalculationStrategy getInstance() {
		if(instance == null) {
			instance = new DivisionCalculationStrategy();
		}
		return instance;
	}
	
	private DivisionCalculationStrategy() {
	}
	
	@Override
	public double calculate(double firstOperand, double secondOperand) {
		return firstOperand / secondOperand;
	}

}
