package NotificationSystem;

import NotificationSystem.notification_decorator.INotification;
import NotificationSystem.notification_observer.NotificationObservable;

import java.util.LinkedList;
import java.util.List;

// singleton class
public class NotificationService {
    private volatile static NotificationService instance;

    private final List<INotification> notifications;
    private final NotificationObservable observable;

    // constructor
    private NotificationService() {
        this.notifications = new LinkedList<>();
        this.observable = new NotificationObservable();
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            synchronized (NotificationService.class) {
                if (instance == null) {
                    instance = new NotificationService();
                }
            }
        }
        return instance;
    }

    public NotificationObservable getObservable() {
        return this.observable;
    }

    public void sendNotification(INotification notification) {
        notifications.add(notification);
        observable.setNotification(notification);
    }
}
