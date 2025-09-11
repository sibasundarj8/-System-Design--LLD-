package paymentGateway;

import core.PaymentRequest;

public class PaymentGatewayProxy extends PaymentGateway {

    private final PaymentGateway realGateway;
    private final Integer retries;

    public PaymentGatewayProxy(PaymentGateway paymentGateway, Integer maxRetries) {
        this.realGateway = paymentGateway;
        this.retries = maxRetries;
    }

    @Override
    public Boolean initiatePayment(PaymentRequest paymentRequest) {
        return realGateway.initiatePayment(paymentRequest);
    }

    @Override
    public Boolean validatePayment(PaymentRequest paymentRequest) {
        return realGateway.validatePayment(paymentRequest);
    }

    @Override
    public Boolean confirmPayment(PaymentRequest paymentRequest) {
        return realGateway.confirmPayment(paymentRequest);
    }

    @Override
    public Boolean processPayment(PaymentRequest paymentRequest) {
        for (int i = 0; i < retries; i++) {
            if (i > 0) System.out.println("[proxy]: retrying...");
            if (realGateway.processPayment(paymentRequest)) return true;
        }

        System.out.println("[proxy]: Payment failed after trying "
                + retries + " attempts for "
                + paymentRequest.sender() + ".");

        return false;
    }
}