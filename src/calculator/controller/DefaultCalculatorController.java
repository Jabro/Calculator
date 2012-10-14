package calculator.controller;

import java.util.ArrayList;
import java.util.Collection;

import calculator.model.Calculator;
import calculator.model.Display;
import calculator.model.Operator;
import calculator.model.events.CalculatorEventListener;
import calculator.model.events.DisplayChangedEvent;
import calculator.model.events.DisplayEventListener;
import calculator.model.events.ResultChangedEvent;
import calculator.view.CalculatorView;
import calculator.view.events.CommandEnteredEvent;
import calculator.view.events.CommandEventListener;
import calculator.view.events.InputEnteredEvent;
import calculator.view.events.InputEventListener;

public class DefaultCalculatorController implements CalculatorController,
CommandEventListener, InputEventListener, CalculatorEventListener, DisplayEventListener{

	private final Calculator calculator;
	private final Collection<CalculatorView> views;
	private final Display display;
	private Double operand;

	public DefaultCalculatorController(Collection<CalculatorView> views) {
		// models
		calculator = new Calculator();
		calculator.addListener(this);
		display = new Display();
		display.addListener(this);
		// views
		for (CalculatorView view : views) {
			configurateView(view);
		}
		this.views = views;
	}

	public DefaultCalculatorController(CalculatorView view) {
		// models
		calculator = new Calculator();
		calculator.addListener(this);
		display = new Display();
		display.addListener(this);
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
		// +-*/=
		if(command.isCalculationRequired()) {
			// prevent overriding of the current operand
			// with the last result
			if(!isNewOperand()) {
				calculator.setOperand(operand);		
			}
			deleteOperand();
			calculator.calculateResult();
			if(command.hasOperator()) {
				calculator.setOperator(command.getOperator());
			} else {
				System.out.println("Test");
				calculator.setOperator(null);
			}
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
		for (CalculatorView view : views) {
			view.updateDisplay(event.getDisplay());
		}
	}

	private void configurateView(CalculatorView view) {
		view.addCommandListener(this);
		view.addInputListener(this);
		view.setModels(createCommands(), createInputValues(), display);
		view.initilize();
	}

	private Collection<Command> createCommands() {
		final Collection<Command> commands = new ArrayList<Command>();
		commands.add(new Command("+", Operator.PLUS));
		commands.add(new Command("-", Operator.MINUS));
		commands.add(new Command("*", Operator.MULTIPLICATION));
		commands.add(new Command("/", Operator.DIVISION));
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
