package calculator.model.pocket.calculator;

import calculator.model.Display;
import calculator.model.Operator;
import calculator.model.pocket.calculator.PocketCalculatorState.States;

public interface PocketCalculatorStateSupport {

	void setState(States state);	

	void setState(States state, boolean operandFinished);
	
	boolean isOperandFinished();
	
	Operator getOperator();
	
	void setOperator(Operator operator);
	
	double getOperand();

	void setOperand(double operand);

	double getLastOperand();

	void setLastOperand(double operand);
	
	Display getDisplay();

}
