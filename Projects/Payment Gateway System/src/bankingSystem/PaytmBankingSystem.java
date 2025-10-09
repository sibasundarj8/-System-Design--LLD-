package bankingSystem;

import java.util.Random;

public class PaytmBankingSystem implements IBankingSystem {

    @Override
    public Boolean processPayment(Double amount) {
        int possibility = new Random().nextInt(0, 100);
        return possibility <= 60;
    }
}