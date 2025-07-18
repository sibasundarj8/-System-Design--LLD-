package Tomato.models;

import Tomato.strategies.PaymentStrategy;

public class PickUpOrder extends Order {
    private String restaurantAddress;

    // constructor
    public PickUpOrder(User user, PaymentStrategy paymentStrategy) {
        super(user, paymentStrategy);
    }

    @Override
    public String getType() {
        return "pickup";
    }

    // getters
    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    // setters
    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }
}