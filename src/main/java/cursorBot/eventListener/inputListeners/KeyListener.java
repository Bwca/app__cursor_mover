package cursorbot.eventListener.inputListeners;

import cursorbot.eventListener.Irrelevant;
import io.reactivex.rxjava3.subjects.PublishSubject;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyListener extends BaseEventEmitter implements NativeKeyListener {

    public KeyListener(PublishSubject<Irrelevant> actionSubject) {
        super(actionSubject);
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        emit();
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }
}
