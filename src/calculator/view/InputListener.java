package calculator.view;

import java.util.EventListener;

public interface InputListener extends EventListener {

	void onInputEntered(InputEnteredEvent event);
	
}
