package calculator.controller;

import java.util.ArrayList;
import java.util.Collection;

import calculator.controller.commands.CalculateCommand;
import calculator.controller.commands.ClearCommand;
import calculator.controller.commands.Command;
import calculator.controller.commands.OperatorCommand;
import calculator.model.Operator;
import calculator.model.PocketCalculator;
import calculator.model.display.event.DisplayChangedEvent;
import calculator.view.CalculatorView;
import calculator.view.event.InputEnteredEvent;

public class PocketCalculatorController implements CalculatorController{

	private final Collection<CalculatorView> views;
	private final PocketCalculator pocketCalculator;

	public PocketCalculatorController(Collection<CalculatorView> views) {
		// model
		pocketCalculator = new PocketCalculator();
		pocketCalculator.addListener(this);		
		// views
		for (CalculatorView view : views) {
			configurateView(view);
		}
		this.views = views;
	}

	public PocketCalculatorController(CalculatorView view) {
		// model
		pocketCalculator = new PocketCalculator();
		pocketCalculator.addListener(this);	
		// views
		views = new ArrayList<CalculatorView>();
		views.add(view);
		configurateView(view);		
	}

	@Override
	public void onInputEntered(InputEnteredEvent event) {
		InputValue input = event.getInput();
		pocketCalculator.useInput(input.getValue());
	}

	@Override
	public void onDisplayChanged(DisplayChangedEvent event) {
		for (CalculatorView view : views) {
			view.updateDisplay(event.getDisplay());
		}
	}

	private void configurateView(CalculatorView view) {
		view.addInputListener(this);
		view.setModels(createCommands(), createInputValues(), pocketCalculator);
		view.initilize();
	}

	private Collection<Command> createCommands() {
		final Collection<Command> commands = new ArrayList<Command>();
		commands.add(new OperatorCommand(pocketCalculator, Operator.PLUS));
		commands.add(new OperatorCommand(pocketCalculator, Operator.MINUS));
		commands.add(new OperatorCommand(pocketCalculator, Operator.MULTIPLICATION));
		commands.add(new OperatorCommand(pocketCalculator, Operator.DIVISION));
		commands.add(new CalculateCommand(pocketCalculator));
		commands.add(new ClearCommand(pocketCalculator));
		commands.add(new OperatorCommand(pocketCalculator, Operator.SQUARE_ROOT));
		return commands;
	}

	private Collection<InputValue> createInputValues() {
		final Collection<InputValue> inputValues = new ArrayList<InputValue>();
		for (int i = 0; i <= 9; i++) {
			inputValues.add(new InputValue(i));
		}
		inputValues.add(new InputValue("."));
		return inputValues;
	}

}
