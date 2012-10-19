package calculator.view.event;

import java.util.EventListener;

public interface InputEventListener extends EventListener {

	void onInputEntered(InputEnteredEvent event);
	
}
