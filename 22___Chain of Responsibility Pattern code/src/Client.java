import atmMachine.ATM;

public class Client {
    /// main Method
    public static void main(String[] args) {
        // atm constructor takes an integer input and set that number of  notes to every handler.
        ATM atm = new ATM(5);

        atm.dispenseMoney(3700);
        atm.dispenseMoney(3750);
        atm.dispenseMoney(2800);
    }
}
