import core.Currency;
import core.PaymentRequest;
import paymentGateway.controller.GatewayController;
import paymentGateway.factory.GatewayType;

public class Client {

    ///  main Method
    public static void main(String[] args) {

        PaymentRequest pr1 = new PaymentRequest("Sibasundar Jena", "Sanjulata Jena", 100000.00, Currency.INR);

        System.out.println("-----------------------Processing via paytm-----------------------");
        boolean ans1 = GatewayController.getInstance().handlePayment(GatewayType.PAYTM, pr1);
        System.out.println("Status: " + (ans1 ? "SUCCESSFUL" : "FAILED"));
        System.out.println("------------------------------------------------------------------\n");


        PaymentRequest pr2 = new PaymentRequest("Sibasundar Jena", "Manoranjan Jena", 100000.00, Currency.INR);

        System.out.println("----------------------Processing via razorpay----------------------");
        boolean ans2 = GatewayController.getInstance().handlePayment(GatewayType.RAZORPAY, pr2);
        System.out.println("Status: " + (ans2 ? "SUCCESSFUL" : "FAILED"));
        System.out.println("-------------------------------------------------------------------\n");
    }
}
