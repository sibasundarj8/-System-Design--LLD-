package NotificationSystem.notification_observer;

import NotificationSystem.notification_decorator.INotification;

public class NotificationObservable extends Observable {
    private INotification notification;

    public void setNotification(INotification notification) {
        this.notification = notification;
        this.notifyObserver();
    }

    public INotification getNotification() {
        return this.notification;
    }

    public String getNotificationContent() {
        return this.notification.content();
    }

    @Override
    protected void notifyObserver() {
        for (Observer observer : super.observers) {
            observer.update();
        }
    }
}