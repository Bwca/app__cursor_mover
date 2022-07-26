package cursorbot;

import cursorbot.cursorSlave.CursorSlave;
import cursorbot.eventListener.EventListener;

import java.awt.*;
import java.util.concurrent.TimeUnit;


/**
 * Cursor mover!
 */
public class App {

    private static final long debounceTime = 2000;

    public static void main(String... args) throws AWTException {
        final CursorSlave cursorSlave = new CursorSlave();

        new EventListener()
                .startListeningToEvents()
                .debounce(debounceTime, TimeUnit.MILLISECONDS)
                .subscribe(v -> cursorSlave.moveTheCursorLikeTheresSomeoneAround());
    }
}
