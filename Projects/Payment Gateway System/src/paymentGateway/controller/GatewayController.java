package paymentGateway.controller;

import core.PaymentRequest;
import paymentGateway.PaymentGateway;
import paymentGateway.factory.GatewayFactory;
import paymentGateway.factory.GatewayType;
import paymentGateway.service.GatewayService;

// singleton
public class GatewayController {
    private volatile static GatewayController instance;

    // object creation denied
    private GatewayController(){}

    public static GatewayController getInstance() {
        if (instance == null) {
            synchronized (GatewayController.class) {
                if (instance == null) {
                    instance = new GatewayController();
                }
            }
        }

        return instance;
    }

    public Boolean handlePayment(GatewayType gatewayType, PaymentRequest paymentRequest) {
        PaymentGateway gateway = GatewayFactory.getInstance().getGateway(gatewayType);
        GatewayService.getInstance().setPaymentGateway(gateway);
        return GatewayService.getInstance().processPayment(paymentRequest);
    }
}
