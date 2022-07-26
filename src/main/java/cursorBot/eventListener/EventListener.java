package cursorbot.eventListener;

import cursorbot.eventListener.inputListeners.KeyListener;
import cursorbot.eventListener.inputListeners.MouseListener;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EventListener {

    private static final PublishSubject<Irrelevant> actionSubject = PublishSubject.create();

    public Observable<Irrelevant> startListeningToEvents() {
        try {
            GlobalScreen.registerNativeHook();

        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        switchOffAnnoyingDebugMessages();

        GlobalScreen.addNativeKeyListener(new KeyListener(actionSubject));

        MouseListener mouseListener = new MouseListener(actionSubject);
        GlobalScreen.addNativeMouseMotionListener(mouseListener);
        GlobalScreen.addNativeMouseWheelListener(mouseListener);

        return Observable.wrap(actionSubject);
    }

    private void switchOffAnnoyingDebugMessages() {
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        logger.setUseParentHandlers(false);
    }
}
