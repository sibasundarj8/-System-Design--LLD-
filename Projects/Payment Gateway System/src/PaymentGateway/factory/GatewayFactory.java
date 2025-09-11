package paymentGateway.factory;

import bankingSystem.PaytmBankingSystem;
import bankingSystem.RazorpayBankingSystem;
import paymentGateway.PaymentGateway;
import paymentGateway.PaymentGatewayPaytm;
import paymentGateway.PaymentGatewayProxy;
import paymentGateway.PaymentGatewayRazorpay;

// singleton
public class GatewayFactory {
    private volatile static GatewayFactory instance;

    // object creation denied
    private GatewayFactory() {}

    public static GatewayFactory getInstance() {
        if (instance == null) {
            synchronized (GatewayFactory.class) {
                if (instance == null) {
                    instance = new GatewayFactory();
                }
            }
        }

        return instance;
    }

    public PaymentGateway getGateway(GatewayType type) {
        return switch (type) {
            case PAYTM -> new PaymentGatewayProxy(new PaymentGatewayPaytm(new PaytmBankingSystem()), 5);
            case RAZORPAY -> new PaymentGatewayProxy(new PaymentGatewayRazorpay(new RazorpayBankingSystem()), 3);
        };
    }
}
