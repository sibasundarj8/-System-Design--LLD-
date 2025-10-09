package paymentGateway.retryStrategies;

import core.PaymentRequest;
import paymentGateway.PaymentGateway;

public class ExponentialBackoffRetryPolicy implements IRetryPolicy {
    private Integer initialWaitingTime;

    public ExponentialBackoffRetryPolicy() {
        this.initialWaitingTime = 1;
    }

    @Override
    public boolean tryPayment(PaymentRequest paymentRequest, PaymentGateway gateway, int maxRetries) {
        for (int i = 0; i < maxRetries; i++) {
            if (i > 0) {
                System.out.println("[ExponentialBackoff]: waiting for " + initialWaitingTime + " sec");
                try {
                    Thread.sleep(1000L * initialWaitingTime);
                    initialWaitingTime *= 2;
                    System.out.println("[ExponentialBackoff]: retrying...");
                } catch (InterruptedException e) {
                    System.err.println("[ExponentialBackoff]: EXCEPTION");
                }
            }
            if (gateway.processPayment(paymentRequest)) return true;
        }

        return false;
    }
}
