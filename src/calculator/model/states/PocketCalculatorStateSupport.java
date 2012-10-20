package calculator.model.states;

import calculator.model.Display;
import calculator.model.Operator;

public interface PocketCalculatorStateSupport {

	void setState(PocketCalculatorState state);	

	void setState(PocketCalculatorState state, boolean operandFinished);
	
	boolean isOperandFinished();
	
	Operator getOperator();
	
	void setOperator(Operator operator);
	
	double getOperand();

	void setOperand(double operand);

	double getLastOperand();

	void setLastOperand(double operand);
	
	Display getDisplay();

}
