package Tomato.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Restaurant restaurant;
    private final List<MenuItem> items = new ArrayList<>();
    private Double totalCost = 0D;

    // constructor
    public Cart() {
        this.restaurant = null;
    }

    // getters
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    // setters
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    // methods
    public void addItem(MenuItem item) {
        if (this.restaurant == null) {
            System.out.println("Cart: Select a restaurant before adding items.");
            return;
        }
        this.items.add(item);
        this.totalCost += item.getPrice();
    }

    public void clearCart() {
        this.items.clear();
        this.restaurant = null;
    }

    public Boolean isEmpty() {
        return restaurant == null || items.isEmpty();
    }
}
