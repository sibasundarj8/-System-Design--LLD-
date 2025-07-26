package NotificationSystem.notification_decorator;

public record SimpleNotification(String content) implements INotification {/*
    ✅ Use a record in Java when:
           ▸ You need a simple, immutable data container.
           ▸ No field updates are required after creation.
           ▸ You want to avoid writing boilerplate (constructor, getters, hashCode, toString, equals).
           ▸ You don’t need class inheritance.
           ▸ You're using it as a DTO or API payload (e.g., in Spring Boot/JSON).
*/}