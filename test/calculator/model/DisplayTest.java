package calculator.model;

import static org.junit.Assert.*;

import org.junit.Test;

import de.youngdevelopers.calculator.model.Display;


public class DisplayTest {

	@Test
	public void testDisplay() {
		assertEquals("0", new Display().getContent());
	}

	@Test
	public void testClearDisplay() {
		Display display = new Display();
		display.setNumber(20.0);
		display.clear();
		assertEquals("0", display.getContent());
	}

	@Test
	public void testAddDigit() {
		Display display = new Display();
		display.addDigit(2);
		assertEquals("2", display.getContent());
	}

	@Test
	public void testAddContentToNotZeroDisplay() {
		Display display = new Display();
		display.addDigit(2);
		display.addContent(".");
		assertEquals("2.", display.getContent());
	}
	
	@Test
	public void testAddContentToZeroDisplay() {
		Display display = new Display();
		display.addDigit(0);
		display.addContent(".");
		assertEquals("0.", display.getContent());
	}
	
	@Test
	public void testAddContentToClearedDisplay() {
		Display display = new Display();
		display.clear();
		display.addContent(".");
		assertEquals("0.", display.getContent());
	}
	
	@Test
	public void testAddTwoDecimalPoints() {
		Display display = new Display();
		display.clear();
		display.addContent(".");
		display.addContent(".");
		assertEquals("0.", display.getContent());
	}
	
	@Test
	public void testAddOneDigitBeteenTwoDecimalPoints() {
		Display display = new Display();
		display.clear();
		display.addContent(".");
		display.addDigit(3);
		display.addContent(".");
		assertEquals("0.3", display.getContent());
	}

	@Test
	public void testSetDisplay() {
		Display display = new Display();
		display.setNumber(20.0);
		assertEquals("20", display.getContent());
	}

}
