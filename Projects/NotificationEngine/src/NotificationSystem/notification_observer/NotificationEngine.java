package NotificationSystem.notification_observer;

import NotificationSystem.NotificationService;
import NotificationSystem.notification_strategies.NotificationStrategy;

import java.util.LinkedList;
import java.util.List;

public class NotificationEngine implements Observer {
    private final NotificationObservable notificationObservable;
    private final List<NotificationStrategy> notificationStrategies;

    // @NoAgsConstructor
    public NotificationEngine() {
        this.notificationObservable = NotificationService.getInstance().getObservable();
        notificationObservable.addObserver(this);
        notificationStrategies = new LinkedList<>();
    }
    // @AllArgsConstructor
    public NotificationEngine(NotificationObservable notificationObservable) {
        this.notificationObservable = notificationObservable;
        this.notificationStrategies = new LinkedList<>();
    }

    // methods
    public void addNotificationStrategy(NotificationStrategy strategy) {
        if (!notificationStrategies.contains(strategy)) {
            this.notificationStrategies.add(strategy);
        }
    }

    @Override
    public void update() {
        for (NotificationStrategy strategy : notificationStrategies) {
            strategy.sendNotification(notificationObservable.getNotificationContent());
        }
    }
}