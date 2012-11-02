package calculator.model;

import static org.junit.Assert.*;

import org.junit.Test;

import de.youngdevelopers.calculator.model.pocketcalculator.display.PocketCalculatorDisplay;


public class PocketCalculatorDisplayTest {

	@Test
	public void testPocketCalculatorDisplay() {
		assertEquals("0", new PocketCalculatorDisplay().getContent());
	}

	@Test
	public void testClearPocketCalculatorDisplay() {
		PocketCalculatorDisplay display = new PocketCalculatorDisplay();
		display.setNumber(20.0);
		display.clear();
		assertEquals("0", display.getContent());
	}

	@Test
	public void testAddDigit() {
		PocketCalculatorDisplay display = new PocketCalculatorDisplay();
		display.addDigit(2);
		assertEquals("2", display.getContent());
	}

	@Test
	public void testAddContentToNotZeroPocketCalculatorDisplay() {
		PocketCalculatorDisplay display = new PocketCalculatorDisplay();
		display.addDigit(2);
		display.addContent(".");
		assertEquals("2.", display.getContent());
	}
	
	@Test
	public void testAddContentToZeroPocketCalculatorDisplay() {
		PocketCalculatorDisplay display = new PocketCalculatorDisplay();
		display.addDigit(0);
		display.addContent(".");
		assertEquals("0.", display.getContent());
	}
	
	@Test
	public void testAddContentToClearedPocketCalculatorDisplay() {
		PocketCalculatorDisplay display = new PocketCalculatorDisplay();
		display.clear();
		display.addContent(".");
		assertEquals("0.", display.getContent());
	}
	
	@Test
	public void testAddTwoDecimalPoints() {
		PocketCalculatorDisplay display = new PocketCalculatorDisplay();
		display.clear();
		display.addContent(".");
		display.addContent(".");
		assertEquals("0.", display.getContent());
	}
	
	@Test
	public void testAddOneDigitBeteenTwoDecimalPoints() {
		PocketCalculatorDisplay display = new PocketCalculatorDisplay();
		display.clear();
		display.addContent(".");
		display.addDigit(3);
		display.addContent(".");
		assertEquals("0.3", display.getContent());
	}

	@Test
	public void testSetPocketCalculatorDisplay() {
		PocketCalculatorDisplay display = new PocketCalculatorDisplay();
		display.setNumber(20.0);
		assertEquals("20", display.getContent());
	}

}
