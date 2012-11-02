package de.youngdevelopers.calculator.model;


public interface Calculator {

	void addListener(DisplayEventListener listener);

	void removeListener(DisplayEventListener listener);

	void useOperator(Operator operator);

	void calculateFromEqualSign();

	void useInput(String input);

	void executeClear();

	Display getDisplay();

}
