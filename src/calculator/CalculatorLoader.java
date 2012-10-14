package calculator;

import java.util.ArrayList;
import java.util.Collection;

import calculator.controller.DefaultCalculatorController;
import calculator.view.CalculatorView;
import calculator.view.DefaultCalculatorView;

public class CalculatorLoader {

	public static void main(String[] args) {
		// views
		Collection<CalculatorView> views = new ArrayList<CalculatorView>();
		views.add(new DefaultCalculatorView());
		views.add(new DefaultCalculatorView());
		// controller
		new DefaultCalculatorController(views);
	}

}
