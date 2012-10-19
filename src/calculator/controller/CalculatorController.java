package calculator.controller;

import calculator.model.events.DisplayEventListener;
import calculator.view.events.InputEventListener;

public interface CalculatorController extends InputEventListener, DisplayEventListener{
}
