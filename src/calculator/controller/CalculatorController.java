package calculator.controller;

import calculator.model.display.event.DisplayEventListener;
import calculator.view.event.InputEventListener;

public interface CalculatorController extends InputEventListener, DisplayEventListener{
}
