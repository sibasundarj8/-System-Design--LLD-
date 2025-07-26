package NotificationSystem.notification_observer;

import java.util.LinkedList;
import java.util.List;

public abstract class Observable {
    protected List<Observer> observers;

    public Observable() {
        observers = new LinkedList<>();
    }

    public void addObserver(Observer observer) {
        if (!this.observers.contains(observer)){
            this.observers.add(observer);
        }
    }
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }
    protected abstract void notifyObserver();
}