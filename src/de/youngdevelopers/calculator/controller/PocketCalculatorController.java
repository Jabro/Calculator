package de.youngdevelopers.calculator.controller;

import java.util.ArrayList;
import java.util.Collection;

import de.youngdevelopers.calculator.controller.commands.CalculateCommand;
import de.youngdevelopers.calculator.controller.commands.ClearCommand;
import de.youngdevelopers.calculator.controller.commands.Command;
import de.youngdevelopers.calculator.controller.commands.InputCommand;
import de.youngdevelopers.calculator.controller.commands.InputDigitCommand;
import de.youngdevelopers.calculator.controller.commands.OperatorCommand;
import de.youngdevelopers.calculator.model.Calculator;
import de.youngdevelopers.calculator.model.Operator;
import de.youngdevelopers.calculator.model.PocketCalculator;
import de.youngdevelopers.calculator.model.display.event.DisplayChangedEvent;
import de.youngdevelopers.calculator.model.display.event.DisplayEventListener;
import de.youngdevelopers.calculator.view.CalculatorView;

public class PocketCalculatorController implements CalculatorController, DisplayEventListener {

	private static final int FIRST_DIGIT = 0;
	private static final int LAST_DIGIT = 9;
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
		createInputCommands(commands);
		createNonInputCommands(commands);
		return commands;
	}

	private void createInputCommands(final Collection<Command> commands) {
		for (int i = FIRST_DIGIT; i <= LAST_DIGIT; i++) {
			commands.add(new InputDigitCommand(calculator, i));
		}
		commands.add(new InputCommand(calculator, "."));
	}

	private void createNonInputCommands(final Collection<Command> commands) {
		for (Operator operator : Operator.values()) {
			if(operator == Operator.SQUARE_ROOT) {
				continue;
			}
			commands.add(new OperatorCommand(calculator, operator));
		}
		commands.add(new CalculateCommand(calculator));
		commands.add(new ClearCommand(calculator));
		commands.add(new OperatorCommand(calculator, Operator.SQUARE_ROOT));
	}

}
