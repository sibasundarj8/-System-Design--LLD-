package Tomato.strategies;

public class NetBanking implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Net Banking");
    }
}