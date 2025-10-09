package paymentGateway.service;

import core.PaymentRequest;
import paymentGateway.PaymentGateway;

// singleton
public class GatewayService {
    public static volatile GatewayService instance;
    private PaymentGateway paymentGateway;

    // object creation denied
    private GatewayService() {}

    public static GatewayService getInstance() {
        if (instance == null) {
            synchronized (GatewayService.class) {
                if (instance == null) {
                    instance = new GatewayService();
                }
            }
        }

        return instance;
    }

    public void setPaymentGateway(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public Boolean processPayment(PaymentRequest paymentRequest) {
        if (paymentGateway == null) {
            System.out.println("[GatewayService]: No payment gateway selected.");
            return false;
        }

        return paymentGateway.processPayment(paymentRequest);
    }
}
