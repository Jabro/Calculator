package calculator.test.framework;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import de.youngdevelopers.calculator.controller.commands.Command;
import de.youngdevelopers.calculator.model.Calculator;
import de.youngdevelopers.calculator.model.Display;
import de.youngdevelopers.calculator.view.CalculatorView;

public class MockCalculatorView implements CalculatorView, CalculationTestSupport {

	private String content;
	private Map<String, Command> commands = new HashMap<String, Command>();

	public void enterDigit(int digit) {
		commands.get(String.valueOf(digit)).execute();
	}

	public void assertDisplay(double expected) {
		assertEquals(expected, (double)Double.valueOf(content), INACCURACY);
	}

	@Override
	public void updateDisplay(Display display) {
		this.content = display.getContent();		
	}

	@Override
	public void initilize(Collection<Command> commands, Calculator calculator) {
		this.content = calculator.getDisplay().getContent();
		for (Command command : commands) {
			this.commands.put(command.getName(), command);
		}
	}

	public void enterCommand(String name) {
		commands.get(name).execute();
	}

}
