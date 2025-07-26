import NotificationSystem.NotificationService;
import NotificationSystem.notification_decorator.INotification;
import NotificationSystem.notification_decorator.SignatureDecorator;
import NotificationSystem.notification_decorator.SimpleNotification;
import NotificationSystem.notification_decorator.TimeStampDecorator;
import NotificationSystem.notification_observer.Logger;
import NotificationSystem.notification_observer.NotificationEngine;
import NotificationSystem.notification_observer.NotificationObservable;
import NotificationSystem.notification_strategies.EmailStrategy;
import NotificationSystem.notification_strategies.PopUpStrategy;
import NotificationSystem.notification_strategies.SmsStrategy;

public class Client {
    public static void main(String[] args) {
        // notification service
        NotificationService notificationService = NotificationService.getInstance();

        // notification observable
        NotificationObservable observable = notificationService.getObservable();

        // logger
        Logger logger = new Logger();

        // notification engine
        NotificationEngine notificationEngine = new NotificationEngine();

        // adding strategies
        notificationEngine.addNotificationStrategy(new SmsStrategy("9861238881"));
        notificationEngine.addNotificationStrategy(new EmailStrategy("sibasundarj8@gmail.com"));
        notificationEngine.addNotificationStrategy(new PopUpStrategy());

        // notification
        INotification notification = new SimpleNotification("new message from Her");
        notification = new TimeStampDecorator(notification);
        notification = new SignatureDecorator(notification, "Sibasundar jena");

        notificationService.sendNotification(notification);
    }
}
