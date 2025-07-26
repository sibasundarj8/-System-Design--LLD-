package NotificationSystem.notification_strategies;

public class PopUpStrategy implements NotificationStrategy {
    @Override
    public void sendNotification(String content) {
        System.out.println("\nSending pop-up notification");
        System.out.println(content);
    }
}