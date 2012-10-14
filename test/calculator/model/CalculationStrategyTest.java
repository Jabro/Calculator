package calculator.model;

import static org.junit.Assert.*;

import org.junit.Test;

import calculator.model.calculation.strategies.DivisionCalculationStrategy;
import calculator.model.calculation.strategies.MinusCalculationStrategy;
import calculator.model.calculation.strategies.MultiplicationCalculationStrategy;
import calculator.model.calculation.strategies.PlusCalculationStrategy;

public class CalculationStrategyTest implements CalculationTest {
	
	@Test
	public void testPlus() {
		assertEquals(7, new PlusCalculationStrategy().calculate(3, 4), INACCURACY);
	}
	
	@Test
	public void testMinus() {
		assertEquals(-1, new MinusCalculationStrategy().calculate(3, 4), INACCURACY);
	}
	
	@Test
	public void testMultiplication() {
		assertEquals(12, new MultiplicationCalculationStrategy().calculate(3, 4), INACCURACY);
	}
	
	@Test
	public void testDivision() {
		assertEquals(.75, new DivisionCalculationStrategy().calculate(3, 4), INACCURACY);
	}

}
