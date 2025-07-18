package Tomato.factories;

import Tomato.models.Order;
import Tomato.models.User;
import Tomato.strategies.PaymentStrategy;

import java.time.LocalDateTime;

public interface OrderFactory {
    Order createOrder(User user, PaymentStrategy paymentStrategy, String orderType);
}