package calculator.controller;

import calculator.model.Calculator;
import calculator.model.CalculatorListener;
import calculator.model.ResultChangedEvent;
import calculator.view.CalculatorView;
import calculator.view.CommandEnteredEvent;
import calculator.view.CommandListener;
import calculator.view.InputEnteredEvent;
import calculator.view.InputListener;


public class CalculatorController implements CommandListener, InputListener, CalculatorListener{

	private Calculator calculator;
	private final CalculatorView view;

	public CalculatorController(CalculatorView view) {
		this.view = view;
		view.addCommandListener(this);
		view.addInputListener(this);
		calculator = new Calculator();
		calculator.addCalculatorListener(this);
	}

	@Override
	public void onCommandEntered(CommandEnteredEvent event) {
		Command command = event.getCommand();
		System.out.println(command.getName());
		if(command.getOperator() != null) {
			calculator.setOperator(command.getOperator());
		}
		calculator.calculateResult();
	}

	@Override
	public void onInputEntered(InputEnteredEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onResultChanged(ResultChangedEvent event) {
		view.updateDisplay(String.valueOf(event.getResult()));
	}


}
