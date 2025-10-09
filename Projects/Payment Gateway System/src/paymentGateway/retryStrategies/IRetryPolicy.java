package paymentGateway.retryStrategies;

import core.PaymentRequest;
import paymentGateway.PaymentGateway;

public interface IRetryPolicy {
    boolean tryPayment(PaymentRequest paymentRequest, PaymentGateway gateway, int maxRetries);
}