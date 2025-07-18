package Tomato.managers;

import Tomato.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private volatile static OrderManager instance;

    private final List<Order> orders;

    private OrderManager() {
        orders = new ArrayList<>();
        // no one can create object from outside.
    }

    // methods
    public static OrderManager getInstance() {
        if (instance == null) {
            synchronized (OrderManager.class) {
                if (instance == null) {
                    instance = new OrderManager();
                }
            }
        }

        return instance;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void cancelOrder(Order order) {
        for (Order o : orders) {
            if (o.getId().equals(order.getId())) {
                orders.remove(o);
                break;
            }
        }
    }

    public void listOrders() {
        System.out.println("/n--- All Orders ---");
        for (Order o : orders) {
            System.out.println(o.getType()
                    + " order for " + o.getUser().getName()
                    + " | Total: ₹" + o.getTotal()
                    + " | On: " + o.getScheduled());
        }
    }
}
