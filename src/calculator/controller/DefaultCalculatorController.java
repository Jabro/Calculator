package calculator.controller;

import java.util.ArrayList;
import java.util.Collection;

import calculator.model.Calculator;
import calculator.model.CalculatorListener;
import calculator.model.ResultChangedEvent;
import calculator.model.operator.DivisionOperator;
import calculator.model.operator.MinusOperator;
import calculator.model.operator.MultiplicationOperator;
import calculator.model.operator.PlusOperator;
import calculator.view.CalculatorView;
import calculator.view.CommandEnteredEvent;
import calculator.view.CommandListener;
import calculator.view.InputEnteredEvent;
import calculator.view.InputListener;

public class DefaultCalculatorController implements CalculatorController, CommandListener, InputListener, CalculatorListener{

	private final Calculator calculator;
	private final CalculatorView view;
	private final Collection<Command>    commands    = new ArrayList<Command>();
	private final Collection<InputValue> inputValues = new ArrayList<InputValue>();

	public DefaultCalculatorController(CalculatorView view) {
		this.view = view;
		view.addCommandListener(this);
		view.addInputListener(this);
		calculator = new Calculator();
		calculator.addCalculatorListener(this);
		createCommands();
		createInputValues();
	}

	@Override
	public void onCommandEntered(CommandEnteredEvent event) {
		Command command = event.getCommand();
		System.out.println(command.getName());
		if(command.isCalculationRequired()) {
			calculator.calculateResult();
		}
		if(command.hasOperator()) {
			calculator.setOperator(command.getOperator());
		}
	}

	@Override
	public void onInputEntered(InputEnteredEvent event) {
		InputValue input = event.getInput();
		System.out.println(input.getValue());
	}

	@Override
	public void onResultChanged(ResultChangedEvent event) {
		view.updateDisplay(String.valueOf(event.getResult()));
	}

	@Override
	public Collection<Command> getCommands() {
		return commands;
	}

	@Override
	public Collection<InputValue> getInputValues() {
		return inputValues;
	}

	private void createCommands() {
		commands.add(new Command("+", new PlusOperator()));
		commands.add(new Command("-", new MinusOperator()));
		commands.add(new Command("*", new MultiplicationOperator()));
		commands.add(new Command("/", new DivisionOperator()));
		commands.add(new Command("=", true));
		commands.add(new Command("C"));
		commands.add(new Command("sqrt"));
	}

	private void createInputValues() {
		for (int i = 0; i <= 9; i++) {
			inputValues.add(new InputValue(i));
		}
		inputValues.add(new InputValue("."));
	}


}
