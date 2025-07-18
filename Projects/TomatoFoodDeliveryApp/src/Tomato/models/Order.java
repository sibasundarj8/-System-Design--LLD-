package Tomato.models;

import Tomato.strategies.PaymentStrategy;

import java.time.LocalDateTime;

public abstract class Order {
    private static int nextOrderId = 0;

    protected Integer id;
    protected User user;
    protected Restaurant restaurant;
    protected PaymentStrategy paymentStrategy;
    protected Double total;
    protected LocalDateTime scheduled;

    // no args constructor
    public Order() {
        this.user = null;
        this.restaurant = null;
        this.paymentStrategy = null;
        this.total = 0D;
        this.scheduled = null;
        this.id = ++nextOrderId;
    }

    // all args constructor
    public Order(User user, PaymentStrategy paymentStrategy) {
        this.user = user;
        this.paymentStrategy = paymentStrategy;
        this.restaurant = this.user.getCart().getRestaurant();
        this.total = user.getCart().getTotalCost();
        this.id = ++nextOrderId;
    }

    // setters
    public void setUser(User user) {
        this.user = user;
        this.restaurant = user.getCart().getRestaurant();
        this.total = user.getCart().getTotalCost();
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setScheduled(LocalDateTime scheduled) {
        this.scheduled = scheduled;
    }

    // getters
    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public Double getTotal() {
        return total;
    }

    public LocalDateTime getScheduled() {
        return scheduled;
    }

    // abstract methods
    public abstract String getType();

    // concrete methods
    public boolean processPayment() {
        if (paymentStrategy != null) {
            System.out.println("Processing payment...");
            paymentStrategy.pay(total);
            return true;
        } else {
            System.out.println("Order: select payment strategy.");
            return false;
        }
    }
}