package calculator.controller;

import java.util.ArrayList;
import java.util.Collection;

import calculator.model.Calculator;
import calculator.model.Display;
import calculator.model.events.CalculatorEventListener;
import calculator.model.events.DisplayChangedEvent;
import calculator.model.events.DisplayEventListener;
import calculator.model.events.ResultChangedEvent;
import calculator.model.operator.DivisionOperator;
import calculator.model.operator.MinusOperator;
import calculator.model.operator.MultiplicationOperator;
import calculator.model.operator.PlusOperator;
import calculator.view.CalculatorView;
import calculator.view.events.CommandEnteredEvent;
import calculator.view.events.CommandEventListener;
import calculator.view.events.InputEnteredEvent;
import calculator.view.events.InputEventListener;

public class DefaultCalculatorController implements CalculatorController,
CommandEventListener, InputEventListener, CalculatorEventListener, DisplayEventListener{

	private final Calculator calculator;
	private final CalculatorView view;
	private final Display display;
	private Double operand;

	public DefaultCalculatorController(CalculatorView view) {
		calculator = new Calculator();
		calculator.addListener(this);
		display = new Display();
		display.addListener(this);
		this.view = view;
		view.addCommandListener(this);
		view.addInputListener(this);
		view.createFrame(createCommands(), createInputValues(), display);
	}

	@Override
	public void onCommandEntered(CommandEnteredEvent event) {
		Command command = event.getCommand();
		System.out.println(command.getName());
		// +-*/=
		if(command.isCalculationRequired()) {
			// prevent overriding of the current operand
			// with the last result
			if(!isNewOperand()) {
				calculator.setOperand(operand);
			}
			calculator.calculateResult();
			deleteOperand();
		}
		//TODO support clear
		//TODO support square root
		if(command.hasOperator()) {
			calculator.setOperator(command.getOperator());
		}
	}

	@Override
	public void onInputEntered(InputEnteredEvent event) {
		InputValue input = event.getInput();
		if(isNewOperand()){
			display.clear();
		}
		if(input.isDigit()) {
			display.addDigit(input.getDigit());
		} else {
			display.addContent(input.getValue());
		}
		operand = display.getNumber();
	}

	public void deleteOperand() {
		operand = null;
	}

	public boolean isNewOperand() {
		return operand == null;
	}

	@Override
	public void onResultChanged(ResultChangedEvent event) {
		display.setDisplay(event.getResult());
	}

	@Override
	public void onDisplayChanged(DisplayChangedEvent event) {
		view.updateDisplay(event.getContent());
	}

	private Collection<Command> createCommands() {
		final Collection<Command> commands = new ArrayList<Command>();
		commands.add(new Command("+", new PlusOperator()));
		commands.add(new Command("-", new MinusOperator()));
		commands.add(new Command("*", new MultiplicationOperator()));
		commands.add(new Command("/", new DivisionOperator()));
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
