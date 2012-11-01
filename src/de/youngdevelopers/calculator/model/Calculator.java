package de.youngdevelopers.calculator.model;

import de.youngdevelopers.calculator.model.display.event.DisplayEventListener;

public interface Calculator {

	void addListener(DisplayEventListener listener);

	void removeListener(DisplayEventListener listener);

	void useOperator(Operator operator);

	void calculateFromEqualSign();

	void useInput(String input);

	void executeClear();

	Display getDisplay();

}
