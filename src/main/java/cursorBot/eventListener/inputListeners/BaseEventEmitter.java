package cursorbot.eventListener.inputListeners;

import cursorbot.eventListener.Irrelevant;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class BaseEventEmitter {
    protected final PublishSubject<Irrelevant> actionSubject;

    public BaseEventEmitter(PublishSubject<Irrelevant> actionSubject) {
        this.actionSubject = actionSubject;
    }

    protected void emit() {
        actionSubject.onNext(Irrelevant.INSTANCE);
    }
}
