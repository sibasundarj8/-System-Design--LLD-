package paymentGateway;

import bankingSystem.IBankingSystem;
import bankingSystem.PaytmBankingSystem;
import core.Currency;
import core.PaymentRequest;

public class PaymentGatewayPaytm extends PaymentGateway {

    public PaymentGatewayPaytm() {
        this.bankingSystem = new PaytmBankingSystem();
    }

    @Override
    public Boolean initiatePayment(PaymentRequest paymentRequest) {
        System.out.println("[paytm] initiating payment of "
                + paymentRequest.amount() + " "
                + paymentRequest.currency() + " for "
                + paymentRequest.sender() + "...");

        return bankingSystem.processPayment(paymentRequest.amount());
    }

    @Override
    public Boolean validatePayment(PaymentRequest paymentRequest) {
        System.out.println("[paytm] validating payment of "
                + paymentRequest.amount() + " "
                + paymentRequest.currency() + " for "
                + paymentRequest.sender() + "...");

        return paymentRequest.currency() == Currency.INR && paymentRequest.amount() > 0;
    }

    @Override
    public Boolean confirmPayment(PaymentRequest paymentRequest) {
        System.out.println("[paytm] confirming payment of "
                + paymentRequest.amount() + " "
                + paymentRequest.currency() + " for "
                + paymentRequest.sender() + "...");

        return true;
    }
}