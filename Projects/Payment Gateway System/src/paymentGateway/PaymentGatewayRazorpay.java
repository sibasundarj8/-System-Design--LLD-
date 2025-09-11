package paymentGateway;

import bankingSystem.IBankingSystem;
import core.Currency;
import core.PaymentRequest;

public class PaymentGatewayRazorpay extends PaymentGateway {

    public PaymentGatewayRazorpay(IBankingSystem bankingSystem) {
        this.bankingSystem = bankingSystem;
    }

    @Override
    public Boolean initiatePayment(PaymentRequest paymentRequest) {
        System.out.println("[razorpay] initiating payment of "
                + paymentRequest.amount() + " "
                + paymentRequest.currency() + " for "
                + paymentRequest.sender() + "...");

        return bankingSystem.processPayment(paymentRequest.amount());
    }

    @Override
    public Boolean validatePayment(PaymentRequest paymentRequest) {
        System.out.println("[razorpay] validating payment of "
                + paymentRequest.amount() + " "
                + paymentRequest.currency() + " for "
                + paymentRequest.sender() + "...");

        return paymentRequest.currency() == Currency.INR && paymentRequest.amount() > 0;
    }

    @Override
    public Boolean confirmPayment(PaymentRequest paymentRequest) {
        System.out.println("[razorpay] confirming payment of "
                + paymentRequest.amount() + " "
                + paymentRequest.currency() + " for "
                + paymentRequest.sender() + "...");

        return true;
    }
}