import Tomato.TomatoApp;
import Tomato.models.Order;
import Tomato.models.Restaurant;
import Tomato.models.User;
import Tomato.strategies.UPI;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        // creating an object of tomato app.
        TomatoApp tomato = new TomatoApp();

        // User coming in
        User user = new User(236, "Sibasundar Jena", "Bhubaneswar");
        System.out.println("User: " + user.getName() + " is active.");

        // User searches restaurants based on his location
        List<Restaurant> restaurants = tomato.searchRestaurants("Bhubaneswar");

        if (restaurants.isEmpty()) {
            System.out.println("No restaurant found");
            return;
        }

        System.out.println("\nFound restaurants: ");
        for (Restaurant restaurant : restaurants) {
            System.out.println("  - " + restaurant.getName());
        }

        // user selects a restaurant
        tomato.selectRestaurant(user, restaurants.get(0));
        System.out.println("\nSelected restaurant: " + restaurants.get(0).getName());

        // user adds items to cart
        tomato.addToCart(user, 111);
        tomato.addToCart(user, 113);

        tomato.printUserCart(user);

        // user checkout the cart
        Order order = tomato.checkOutNow(user, new UPI("9861238881"), "delivery");

        // usr pays for the order
        tomato.payForOrder(user, order);
    }
}
