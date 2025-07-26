package NotificationSystem.notification_strategies;

public class EmailStrategy implements NotificationStrategy {
    private final String emailAddress;

    public EmailStrategy(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void sendNotification(String content) {
        System.out.println("\nSending email notification to :: " + emailAddress);
        System.out.println(content);
    }
}
