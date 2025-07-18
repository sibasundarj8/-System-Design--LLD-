package Tomato.models;

import Tomato.strategies.PaymentStrategy;

import java.time.LocalDateTime;

public class DeliveryOrder extends Order {
    private String userAddress;

    // constructor
    public DeliveryOrder(User user, PaymentStrategy paymentStrategy) {
        super(user, paymentStrategy);
    }

    @Override
    public String getType() {
        return "delivery";
    }

    // getters
    public String getUserAddress() {
        return userAddress;
    }

    // setters
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}