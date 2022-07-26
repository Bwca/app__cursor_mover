package cursorbot;

import cursorbot.cursorSlave.CursorSlave;
import cursorbot.eventListener.EventListener;

import java.awt.*;
import java.util.concurrent.TimeUnit;


/**
 * Cursor mover!
 */
public class App {

    public static void main(String... args) throws AWTException {

        final int debounceTime = Integer.parseInt(args[0]);

        final CursorSlave cursorSlave = new CursorSlave();

        new EventListener()
                .startListeningToEvents()
                .debounce(debounceTime, TimeUnit.MINUTES)
                .subscribe(v -> cursorSlave.moveTheCursorLikeTheresSomeoneAround(), e -> {
                    System.out.println(e);
                });
    }
}
