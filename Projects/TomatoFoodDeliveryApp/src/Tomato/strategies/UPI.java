package Tomato.strategies;

public class UPI implements PaymentStrategy {
    private final String mobileNumber;

    // constructor
    public UPI(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI (" + mobileNumber + ")");
    }
}