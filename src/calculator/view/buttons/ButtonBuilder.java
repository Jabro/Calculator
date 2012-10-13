package calculator.view.buttons;

import javax.swing.JButton;

public abstract class ButtonBuilder {

	protected JButton button;
	protected Object reference;

	public void createNewButton(Object reference) {
		this.reference = reference;
		button = new JButton();
	}

	public abstract void buildText();
	public abstract void buildStyle();
	public abstract void buildActionListener(final ButtonListener listener);
	
	public JButton getButton() {
		return button;
	}
	
}
