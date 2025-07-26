package NotificationSystem.notification_decorator;

import java.time.LocalDateTime;

public class TimeStampDecorator extends NotificationDecorator {

    public TimeStampDecorator(INotification notification) {
        super(notification);
    }

    @Override
    public String content() {
        return "[" + LocalDateTime.now() + "]-  " + notification.content();
    }
}
