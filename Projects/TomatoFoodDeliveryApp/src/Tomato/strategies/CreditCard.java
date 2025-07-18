package Tomato.strategies;

public class CreditCard implements PaymentStrategy {
    private final String cardNumber;

    // constructor
    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit card (" + cardNumber + ")");
    }
}
