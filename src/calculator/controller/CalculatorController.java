package calculator.controller;

import calculator.model.events.DisplayEventListener;
import calculator.view.events.CommandEventListener;
import calculator.view.events.InputEventListener;

public interface CalculatorController extends
CommandEventListener, InputEventListener, DisplayEventListener{

}
