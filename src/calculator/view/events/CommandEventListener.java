package calculator.view.events;

import java.util.EventListener;

public interface CommandEventListener extends EventListener{

	void onCommandEntered(CommandEnteredEvent event);

}
