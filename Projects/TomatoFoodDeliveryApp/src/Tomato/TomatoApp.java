package Tomato;

import Tomato.factories.OrderFactory;
import Tomato.factories.ScheduledOrderFactory;
import Tomato.factories.nowOrderFactory;
import Tomato.managers.RestaurantManager;
import Tomato.models.*;
import Tomato.services.NotificationService;
import Tomato.strategies.PaymentStrategy;

import java.time.LocalDateTime;
import java.util.List;

public class TomatoApp {
    // constructor
    public TomatoApp() {
        initialize();
    }

    // methods
    private void initialize() {
        Restaurant restaurant1 = new Restaurant("Dalchini", "Bhubaneswar");
        restaurant1.addMenuItem(new MenuItem(111, "Chicken Dum Biryani", 150.00));
        restaurant1.addMenuItem(new MenuItem(112, "Paneer Dum Biryani", 120.00));
        restaurant1.addMenuItem(new MenuItem(113, "Alu Paratha", 50.00));

        Restaurant restaurant2 = new Restaurant("Master Chef", "Bhadrak");
        restaurant2.addMenuItem(new MenuItem(111, "Chicken Biryani", 130.00));
        restaurant2.addMenuItem(new MenuItem(112, "Veg Dum Biryani", 110.00));
        restaurant2.addMenuItem(new MenuItem(113, "Paneer Chilly", 60.00));

        Restaurant restaurant3 = new Restaurant("Sai Hotel", "Bhubaneswar");
        restaurant3.addMenuItem(new MenuItem(111, "Chicken Dum Biryani", 120.00));
        restaurant3.addMenuItem(new MenuItem(112, "Paneer Tika", 90.00));
        restaurant3.addMenuItem(new MenuItem(113, "Chilly Chicken", 80.00));

        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(restaurant1);
        restaurantManager.addRestaurant(restaurant2);
        restaurantManager.addRestaurant(restaurant3);
    }

    public List<Restaurant> searchRestaurants(String location) {
        return RestaurantManager.getInstance().searchByLocation(location);
    }

    public void selectRestaurant(User user, Restaurant restaurant) {
        user.getCart().setRestaurant(restaurant);
    }

    public void addToCart(User user, Integer itemCode) {
        Cart cart = user.getCart();
        Restaurant restaurant = cart.getRestaurant();

        if (restaurant == null) {
            System.out.println("Select a restaurant first.");
            return;
        }

        for (MenuItem item : restaurant.getItems()){
            if (itemCode.equals(item.getCode())) {
                cart.addItem(item);
                break;
            }
        }
    }

    private Order checkOut(User user, PaymentStrategy paymentStrategy, String orderType, OrderFactory orderFactory) {
        if (user.getCart().isEmpty()) return null;
        return orderFactory.createOrder(user, paymentStrategy, orderType);
    }

    public Order checkOutNow(User user, PaymentStrategy paymentStrategy, String orderType) {
        return checkOut(user, paymentStrategy, orderType, new nowOrderFactory());
    }

    public Order checkOutScheduled(User user, PaymentStrategy paymentStrategy, String orderType, LocalDateTime schedule) {
        return checkOut(user, paymentStrategy, orderType, new ScheduledOrderFactory(schedule));
    }

    public void payForOrder(User user, Order order) {
        boolean success = order.processPayment();

        if (success) {
            NotificationService.notifyUser(order);
            user.getCart().clearCart();
        }
    }

    public void printUserCart(User user) {
        System.out.println("\nItems in cart: ");
        System.out.println("--------------------------------");

        List<MenuItem> items = user.getCart().getItems();
        for (MenuItem item : items) {
            System.out.println(" - " + item.getName() + "(₹" + item.getPrice() + ")");
        }

        System.out.println("Total:\t" + user.getCart().getTotalCost());
        System.out.println("--------------------------------\n");
    }
}
