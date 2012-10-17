package calculator.model.calculation.strategies;

public class SquareRootCalculationStrategy extends UnaryCalculationStrategy {

	private static CalculationStrategy instance;

	public static CalculationStrategy getInstance() {
		if(instance == null) {
			instance = new SquareRootCalculationStrategy();
		}
		return instance;
	}
	
	private SquareRootCalculationStrategy() {
	}

	@Override
	public double calculate(double operand) {
		return Math.sqrt(operand);
	}	

}
