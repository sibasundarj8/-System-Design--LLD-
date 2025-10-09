package paymentGateway.retryStrategies;

import core.PaymentRequest;
import paymentGateway.PaymentGateway;

public class LinearRetryPolicy implements IRetryPolicy {

    @Override
    public boolean tryPayment(PaymentRequest paymentRequest, PaymentGateway gateway, int maxRetries) {

        for (int i = 0; i < maxRetries; i++) {
            if (i > 0) System.out.println("[linear]: retrying...");
            if (gateway.processPayment(paymentRequest)) return true;
        }

        return false;
    }
}