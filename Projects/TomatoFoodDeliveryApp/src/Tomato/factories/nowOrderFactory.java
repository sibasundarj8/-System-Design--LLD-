package Tomato.factories;

import Tomato.models.DeliveryOrder;
import Tomato.models.Order;
import Tomato.models.PickUpOrder;
import Tomato.models.User;
import Tomato.strategies.PaymentStrategy;

import java.time.LocalDateTime;

public class nowOrderFactory implements OrderFactory {
    private final LocalDateTime scheduledTime = LocalDateTime.now();

    @Override
    public Order createOrder(User user, PaymentStrategy paymentStrategy, String orderType) {
        Order order;

        switch (orderType) {
            case "delivery" -> {
                DeliveryOrder deliveryOrder = new DeliveryOrder(user, paymentStrategy);
                deliveryOrder.setUserAddress(user.getAddress());
                order = deliveryOrder;
            }
            case "pickup" -> {
                PickUpOrder pickUpOrder = new PickUpOrder(user, paymentStrategy);
                pickUpOrder.setRestaurantAddress(user.getCart().getRestaurant().getAddress());
                order = pickUpOrder;
            }
            default -> throw new RuntimeException("choose a correct type of order!");
        }

        order.setScheduled(scheduledTime);
        return order;
    }
}
