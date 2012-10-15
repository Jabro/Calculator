package calculator;

import java.util.ArrayList;
import java.util.Collection;

import calculator.controller.PocketCalculatorController;
import calculator.view.CalculatorView;
import calculator.view.PocketCalculatorView;

public class CalculatorLoader {

	public static void main(String[] args) {
		startPocketCalculator();
		//startPocketCalculatorWithTwoViews()
	}

	private static void startPocketCalculator() {
		new PocketCalculatorController(new PocketCalculatorView());
	}

	private static void startPocketCalculatorWithTwoViews() {
		// views
		Collection<CalculatorView> views = new ArrayList<CalculatorView>();
		views.add(new PocketCalculatorView());
		views.add(new PocketCalculatorView());
		// controller
		new PocketCalculatorController(views);
	}

}
