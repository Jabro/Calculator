package calculator.model;

import static org.junit.Assert.*;

import org.junit.Test;

import calculator.test.framework.CalculationTestSupport;
import de.youngdevelopers.calculator.model.calculation.strategies.CalculationStrategy;
import de.youngdevelopers.calculator.model.calculation.strategies.DivisionCalculationStrategy;
import de.youngdevelopers.calculator.model.calculation.strategies.MinusCalculationStrategy;
import de.youngdevelopers.calculator.model.calculation.strategies.MultiplicationCalculationStrategy;
import de.youngdevelopers.calculator.model.calculation.strategies.PlusCalculationStrategy;
import de.youngdevelopers.calculator.model.calculation.strategies.SquareRootCalculationStrategy;

public class CalculationStrategyTest implements CalculationTestSupport {
	
	@Test
	public void testPlus() {
		assertCalculation(7, PlusCalculationStrategy.getInstance());
	}

	@Test
	public void testMinus() {
		assertCalculation(-1, MinusCalculationStrategy.getInstance());
	}
	
	@Test
	public void testMultiplication() {
		assertCalculation(12, MultiplicationCalculationStrategy.getInstance());
	}
	
	@Test
	public void testDivision() {
		assertCalculation(.75, DivisionCalculationStrategy.getInstance());
	}
	
	@Test
	public void testSquareRoot() {
		assertEquals(3, SquareRootCalculationStrategy.getInstance().calculate(9), INACCURACY);
	}

	private void assertCalculation(double expected, CalculationStrategy calculationStrategy) {
		assertEquals(expected, calculationStrategy.calculate(FIRST_OPERAND, SECOND_OPERAND), INACCURACY);
	}

}
