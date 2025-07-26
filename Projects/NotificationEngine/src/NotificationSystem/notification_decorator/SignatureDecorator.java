package NotificationSystem.notification_decorator;

public class SignatureDecorator extends NotificationDecorator {
    private final String signature;

    public SignatureDecorator(INotification notification, String signature) {
        super(notification);
        this.signature = signature;
    }

    @Override
    public String content() {
        return notification.content() + "\033[3m   -" + signature + "-\033[0m";
    }
}
