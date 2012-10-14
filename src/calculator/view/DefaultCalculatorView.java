package calculator.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.EventListenerList;

import calculator.controller.Command;
import calculator.controller.DefaultCalculatorController;
import calculator.controller.InputValue;
import calculator.model.Display;
import calculator.view.buttons.ButtonBuilder;
import calculator.view.buttons.ButtonListener;
import calculator.view.buttons.CommandButtonBuilder;
import calculator.view.buttons.InputButtonBuilder;
import calculator.view.events.CommandEnteredEvent;
import calculator.view.events.CommandEventListener;
import calculator.view.events.InputEnteredEvent;
import calculator.view.events.InputEventListener;

public class DefaultCalculatorView implements CalculatorView, ButtonListener{

	private EventListenerList listeners = new EventListenerList();
	private JTextField displayField;

	public DefaultCalculatorView() {
		new DefaultCalculatorController(this);
	}

	@Override
	public void createFrame(Collection<Command> commands,
			Collection<InputValue> inputValues, Display display) {
		
		JButton[] inputButtons = buildButtons(inputValues, new InputButtonBuilder());
		JButton[] commandButtons = buildButtons(commands, new CommandButtonBuilder());
				
		createDisplayField(display);
		JPanel panel = createPanel();
		addButtons(panel, inputButtons);
		addButtons(panel, commandButtons);
		
		JFrame frame = new JFrame("Calculator");
		frame.setLayout(new BorderLayout());
		frame.add(displayField, BorderLayout.NORTH);
		frame.add(panel);		
		frame.setSize(350, 350);		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private void createDisplayField(Display display) {
		displayField = new JTextField(display.getContent());
		displayField.setEditable(false);
	}

	private JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		return panel;
	}

	private void addButtons(JPanel panel, JButton[] buttons) {
		for (int i = 0; i < buttons.length; i++) {
			panel.add(buttons[i]);
		}
	}

	private JButton[] buildButtons(Collection<? extends Object> refences, ButtonBuilder builder) {
		JButton[] buttons = new JButton[refences.size()];
		int i = 0;
		for (final Object reference : refences) {
			builder.createNewButton(reference);
			builder.buildText();
			builder.buildStyle();
			builder.buildActionListener(this);
			buttons[i++] = builder.getButton();
		}
		return buttons;
	}

	@Override
	public void updateDisplay(String content) {
		displayField.setText(content);
	}

	@Override
	public void onCommandButtonClicked(JButton button, Command command) {
		raiseCommandEnteredEvent(new CommandEnteredEvent(this, command));
	}

	@Override
	public void onInputButtonClicked(JButton button, InputValue input) {
		raiseInputEnteredEvent(new InputEnteredEvent(this, input));
	}

	public void addCommandListener(CommandEventListener listener) {
		listeners.add(CommandEventListener.class, listener);
	}

	public void removeCommandListener(CommandEventListener listener) {
		listeners.remove(CommandEventListener.class, listener);
	}

	public void addInputListener(InputEventListener listener) {
		listeners.add(InputEventListener.class, listener);
	}

	public void removeInputListener(InputEventListener listener) {
		listeners.remove(InputEventListener.class, listener);
	}

	private void raiseCommandEnteredEvent(CommandEnteredEvent event) {
		for (CommandEventListener listener : listeners.getListeners(CommandEventListener.class)) {
			listener.onCommandEntered(event);
		}
	}

	private void raiseInputEnteredEvent(InputEnteredEvent event) {
		for (InputEventListener listener : listeners.getListeners(InputEventListener.class)) {
			listener.onInputEntered(event);
		}
	}

}
