package calculator.test.framework;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import calculator.controller.Command;
import calculator.controller.InputValue;
import calculator.model.Display;
import calculator.model.PocketCalculator;
import calculator.view.CalculatorView;
import calculator.view.events.CommandEnteredEvent;
import calculator.view.events.CommandEventListener;
import calculator.view.events.InputEnteredEvent;
import calculator.view.events.InputEventListener;

public class MockCalculatorView implements CalculatorView, CalculationTestSupport {

	private CommandEventListener commandListener;
	private InputEventListener inputListener;
	public String content;

	public void enterDigit(int digit) {
		inputListener.onInputEntered(new InputEnteredEvent(this, new InputValue(digit)));
	}

	public void enterCommand(Command command) {
		commandListener.onCommandEntered(new CommandEnteredEvent(this, command));
	}

	public void assertDisplay(double expected) {
		assertEquals(expected, (double)Double.valueOf(content), INACCURACY);
	}

	@Override
	public void addCommandListener(CommandEventListener listener) {
		commandListener = listener;
	}

	@Override
	public void removeCommandListener(CommandEventListener listener) {
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
			Collection<InputValue> inputValues, PocketCalculator pocketCalculator) {
		this.content = pocketCalculator.getDisplay().getContent();
	}

	@Override
	public void initilize() {
	}

}
