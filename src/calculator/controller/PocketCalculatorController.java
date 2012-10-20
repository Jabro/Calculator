package calculator.controller;

import java.util.ArrayList;
import java.util.Collection;

import calculator.controller.commands.CalculateCommand;
import calculator.controller.commands.ClearCommand;
import calculator.controller.commands.Command;
import calculator.controller.commands.InputCommand;
import calculator.controller.commands.InputDigitCommand;
import calculator.controller.commands.OperatorCommand;
import calculator.model.Calculator;
import calculator.model.Operator;
import calculator.model.PocketCalculator;
import calculator.model.display.event.DisplayChangedEvent;
import calculator.model.display.event.DisplayEventListener;
import calculator.view.CalculatorView;

public class PocketCalculatorController implements CalculatorController, DisplayEventListener {

	private final Collection<CalculatorView> views;
	private final Calculator calculator;

	public PocketCalculatorController(Collection<CalculatorView> views) {
		// model
		calculator = new PocketCalculator();
		calculator.addListener(this);		
		// views
		Collection<Command> commands = createCommands();
		for (CalculatorView view : views) {
			view.initilize(commands , calculator);
		}
		this.views = views;
	}

	public PocketCalculatorController(CalculatorView view) {
		// model
		calculator = new PocketCalculator();
		calculator.addListener(this);	
		// views
		views = new ArrayList<CalculatorView>();
		views.add(view);
		view.initilize(createCommands(), calculator);		
	}

	@Override
	public void onDisplayChanged(DisplayChangedEvent event) {
		for (CalculatorView view : views) {
			view.updateDisplay(event.getDisplay());
		}
	}

	private Collection<Command> createCommands() {
		final Collection<Command> commands = new ArrayList<Command>();
		for (int i = 0; i <= 9; i++) {
			commands.add(new InputDigitCommand(calculator, i));
		}
		commands.add(new InputCommand(calculator, "."));
		for (Operator operator : Operator.values()) {
			if(operator == Operator.SQUARE_ROOT) {
				continue;
			}
			commands.add(new OperatorCommand(calculator, operator));
		}
		commands.add(new CalculateCommand(calculator));
		commands.add(new ClearCommand(calculator));
		commands.add(new OperatorCommand(calculator, Operator.SQUARE_ROOT));
		return commands;
	}

}
