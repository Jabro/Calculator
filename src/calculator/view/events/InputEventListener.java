package calculator.view.events;

import java.util.EventListener;

public interface InputEventListener extends EventListener {

	void onInputEntered(InputEnteredEvent event);
	
}
