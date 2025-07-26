package NotificationSystem.notification_observer;

import NotificationSystem.NotificationService;

public class Logger implements Observer {
    private final NotificationObservable notificationObservable;

    public Logger() {
        this.notificationObservable = NotificationService.getInstance().getObservable();
        notificationObservable.addObserver(this);
    }

    public Logger(NotificationObservable notificationObservable) {
        this.notificationObservable = notificationObservable;
    }

    @Override
    public void update() {
        System.out.println("\n===Logging new notification===\n" + notificationObservable.getNotificationContent());
    }
}
