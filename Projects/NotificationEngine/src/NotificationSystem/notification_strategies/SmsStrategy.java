package NotificationSystem.notification_strategies;

public class SmsStrategy implements NotificationStrategy {
    private final String phoneNumber;

    public SmsStrategy(String number) {
        this.phoneNumber = number;
    }

    @Override
    public void sendNotification(String content) {
        System.out.println("\nSending SMS notification to :: " + phoneNumber);
        System.out.println(content);
    }
}