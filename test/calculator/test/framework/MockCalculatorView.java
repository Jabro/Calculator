package calculator.test.framework;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import calculator.controller.InputValue;
import calculator.controller.commands.Command;
import calculator.model.Calculator;
import calculator.model.Display;
import calculator.view.CalculatorView;
import calculator.view.event.InputEnteredEvent;
import calculator.view.event.InputEventListener;

public class MockCalculatorView implements CalculatorView, CalculationTestSupport {

	private InputEventListener inputListener;
	public String content;
	private Map<String, Command> commands = new HashMap<String, Command>();

	public void enterDigit(int digit) {
		inputListener.onInputEntered(new InputEnteredEvent(this, new InputValue(digit)));
	}

	public void assertDisplay(double expected) {
		assertEquals(expected, (double)Double.valueOf(content), INACCURACY);
	}

	@Override
	public void addInputListener(InputEventListener listener) {
		inputListener = listener;
	}

	@Override
	public void removeInputListener(InputEventListener listener) {
	}

	@Override
	public void updateDisplay(Display display) {
		this.content = display.getContent();		
	}

	@Override
	public void setModels(Collection<Command> commands,
			Collection<InputValue> inputValues, Calculator calculator) {
		this.content = calculator.getDisplay().getContent();
		for (Command command : commands) {
			this.commands .put(command.getName(), command);
		}
	}

	@Override
	public void initilize() {
	}

	public void enterCommand(String name) {
		commands.get(name).execute();
	}

}
