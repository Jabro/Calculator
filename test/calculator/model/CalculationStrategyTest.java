package calculator.model;

import static org.junit.Assert.*;

import org.junit.Test;

import calculator.model.calculation.strategies.CalculationStrategy;
import calculator.model.calculation.strategies.DivisionCalculationStrategy;
import calculator.model.calculation.strategies.MinusCalculationStrategy;
import calculator.model.calculation.strategies.MultiplicationCalculationStrategy;
import calculator.model.calculation.strategies.PlusCalculationStrategy;
import calculator.model.calculation.strategies.SquareRootCalculationStrategy;
import calculator.test.framework.CalculationTestSupport;

public class CalculationStrategyTest implements CalculationTestSupport {
	
	@Test
	public void testPlus() {
		assertCalculation(7, new PlusCalculationStrategy());
	}

	@Test
	public void testMinus() {
		assertCalculation(-1, new MinusCalculationStrategy());
	}
	
	@Test
	public void testMultiplication() {
		assertCalculation(12, new MultiplicationCalculationStrategy());
	}
	
	@Test
	public void testDivision() {
		assertCalculation(.75, new DivisionCalculationStrategy());
	}
	
	@Test
	public void testSquareRoot() {
		assertEquals(3, new SquareRootCalculationStrategy().calculate(9), INACCURACY);
	}

	private void assertCalculation(double expected, CalculationStrategy calculationStrategy) {
		assertEquals(expected, calculationStrategy.calculate(FIRST_OPERAND, SECOND_OPERAND), INACCURACY);
	}

}
