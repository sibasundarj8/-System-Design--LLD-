package core;

public record PaymentRequest(String sender, String receiver, Double amount, Currency currency) {
}
