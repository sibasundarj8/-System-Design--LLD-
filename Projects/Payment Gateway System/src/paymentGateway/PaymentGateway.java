package paymentGateway;

import bankingSystem.IBankingSystem;
import core.PaymentRequest;

public abstract class PaymentGateway {
    protected IBankingSystem bankingSystem;

    protected abstract Boolean initiatePayment(PaymentRequest paymentRequest);

    protected abstract Boolean validatePayment(PaymentRequest paymentRequest);

    protected abstract Boolean confirmPayment(PaymentRequest paymentRequest);

    public Boolean processPayment(PaymentRequest paymentRequest) {
        if (!validatePayment(paymentRequest)) {
            System.out.println("[PaymentGateway] validation failed for " + paymentRequest.sender() + ".");
            return false;
        }
        if (!initiatePayment(paymentRequest)) {
            System.out.println("[PaymentGateway] initiation failed for " + paymentRequest.sender() + ".");
            return false;
        }
        if (!confirmPayment(paymentRequest)) {
            System.out.println("[PaymentGateway] confirmation failed for " + paymentRequest.sender() + ".");
            return false;
        }

        return true;
    }
}
