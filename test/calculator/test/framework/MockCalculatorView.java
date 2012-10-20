package calculator.test.framework;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import calculator.controller.commands.Command;
import calculator.model.Calculator;
import calculator.model.Display;
import calculator.view.CalculatorView;

public class MockCalculatorView implements CalculatorView, CalculationTestSupport {

	public String content;
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
