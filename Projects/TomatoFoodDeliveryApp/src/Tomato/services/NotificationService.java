package Tomato.services;

import Tomato.models.MenuItem;
import Tomato.models.Order;

import java.util.List;

public class NotificationService {

    public static void notifyUser(Order order) {
        if (order != null) {
            System.out.println("\nnotification: New " + order.getType() + " order placed!");
            System.out.println("--------------------------------");
            System.out.println("Order id:\t" + order.getId());
            System.out.println("Costumer:\t" + order.getUser().getName());
            System.out.println("Restaurant:\t" + order.getRestaurant().getName());
            System.out.println("Item ordered: ");

            List<MenuItem> items = order.getUser().getCart().getItems();
            for (MenuItem item : items) {
                System.out.println(" - " + item.getName() + "(₹" + item.getPrice() + ")");
            }

            System.out.println("Total:\t" + order.getTotal());
            System.out.println("Scheduled for: " + order.getScheduled());
            System.out.println("Payment: Done");
            System.out.println("--------------------------------\n");
        } else {
            System.out.println("Select an order to notify the user");
        }
    }
}
