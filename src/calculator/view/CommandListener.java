package calculator.view;

import java.util.EventListener;

public interface CommandListener extends EventListener{

	void onCommandEntered(CommandEnteredEvent event);

}
