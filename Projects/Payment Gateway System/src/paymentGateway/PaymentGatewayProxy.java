package paymentGateway;

import core.PaymentRequest;
import paymentGateway.retryStrategies.IRetryPolicy;

public class PaymentGatewayProxy extends PaymentGateway {

    private final PaymentGateway realGateway;
    private final Integer retries;
    private final IRetryPolicy retryPolicy;

    public PaymentGatewayProxy(PaymentGateway paymentGateway, Integer maxRetries, IRetryPolicy retryPolicy) {
        this.realGateway = paymentGateway;
        this.retries = maxRetries;
        this.retryPolicy = retryPolicy;
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
        if (retryPolicy.tryPayment(paymentRequest, realGateway, retries)) {
            return true;
        }

        System.out.println("[proxy]: Payment failed after trying "
                + retries + " attempts for "
                + paymentRequest.sender() + ".");

        return false;
    }
}