package paymentGateway.factory;

import paymentGateway.PaymentGateway;
import paymentGateway.PaymentGatewayPaytm;
import paymentGateway.PaymentGatewayProxy;
import paymentGateway.PaymentGatewayRazorpay;
import paymentGateway.retryStrategies.ExponentialBackoffRetryPolicy;
import paymentGateway.retryStrategies.LinearRetryPolicy;

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
            case PAYTM -> new PaymentGatewayProxy(new PaymentGatewayPaytm(), 3, new ExponentialBackoffRetryPolicy());
            case RAZORPAY -> new PaymentGatewayProxy(new PaymentGatewayRazorpay(), 2, new LinearRetryPolicy());
        };
    }
}
