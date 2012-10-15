package calculator.controller;

import java.util.ArrayList;
import java.util.Collection;

import calculator.model.Operator;
import calculator.model.PocketCalculator;
import calculator.model.events.DisplayChangedEvent;
import calculator.view.CalculatorView;
import calculator.view.events.CommandEnteredEvent;
import calculator.view.events.InputEnteredEvent;

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

	//TODO support clear
	//TODO support square root
	@Override
	public void onCommandEntered(CommandEnteredEvent event) {
		Command command = event.getCommand();
		if(command.isCalculationRequired()) {
			if(command.hasOperator()) {
				// +-*/
				pocketCalculator.setOperator(command.getOperator());			
			} else {
				// =
				pocketCalculator.calculateFromEqualSign();
			}
		}
	}

	@Override
	public void onInputEntered(InputEnteredEvent event) {
		InputValue input = event.getInput();
		pocketCalculator.addInput(input.getValue());
	}

	@Override
	public void onDisplayChanged(DisplayChangedEvent event) {
		for (CalculatorView view : views) {
			view.updateDisplay(event.getDisplay());
		}
	}

	private void configurateView(CalculatorView view) {
		view.addCommandListener(this);
		view.addInputListener(this);
		view.setModels(createCommands(), createInputValues(), pocketCalculator);
		view.initilize();
	}

	private Collection<Command> createCommands() {
		final Collection<Command> commands = new ArrayList<Command>();
		commands.add(new Command(Operator.PLUS));
		commands.add(new Command(Operator.MINUS));
		commands.add(new Command(Operator.MULTIPLICATION));
		commands.add(new Command(Operator.DIVISION));
		commands.add(new Command("=", true));
		commands.add(new Command("C"));
		commands.add(new Command("sqrt"));
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
