package Tomato.managers;

import Tomato.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {
    private volatile static RestaurantManager obj;

    private final List<Restaurant> restaurants;

    // constructor
    private RestaurantManager() {
        restaurants = new ArrayList<>();
        // nobody can create object from outside.
    }

    // methods
    public static RestaurantManager getInstance() {
        // creating instance only once
        if (obj == null) {
            synchronized (RestaurantManager.class) {
                if (obj == null) {
                    obj = new RestaurantManager();
                }
            }
        }

        return obj;
    }

    public void addRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
    }

    public List<Restaurant> searchByLocation(String location) {
        location = location.toLowerCase();
        List<Restaurant> restaurants = new ArrayList<>();

        for (Restaurant restaurant : this.restaurants) {
            if (restaurant.getAddress().toLowerCase().equals(location)) {
                restaurants.add(restaurant);
            }
        }

        return restaurants;
    }
}