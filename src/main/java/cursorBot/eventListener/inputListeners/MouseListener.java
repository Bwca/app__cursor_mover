package cursorbot.eventListener.inputListeners;

import cursorbot.eventListener.Irrelevant;
import io.reactivex.rxjava3.subjects.PublishSubject;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

public class MouseListener extends BaseEventEmitter implements NativeMouseInputListener, NativeMouseWheelListener {
    public MouseListener(PublishSubject<Irrelevant> actionSubject) {
        super(actionSubject);
    }

    @Override
    public void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {
        emit();
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent nativeMouseEvent) {
        emit();
    }

    @Override
    public void nativeMouseWheelMoved(NativeMouseWheelEvent nativeMouseWheelEvent) {
        emit();
    }

    @Override
    public void nativeMouseDragged(NativeMouseEvent nativeMouseEvent) {

    }

    @Override
    public void nativeMousePressed(NativeMouseEvent nativeMouseEvent) {

    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {

    }
}
