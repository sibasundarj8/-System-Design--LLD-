package atmMachine;

import atmMachine.handler.FiveHundredHandler;
import atmMachine.handler.HundredHandler;
import atmMachine.handler.IHandler;
import atmMachine.handler.ThousandHandler;

public class ATM {
    private final IHandler handler;

    public ATM(int avgNumberOfNotes) {
        this.handler = new ThousandHandler(avgNumberOfNotes);
        IHandler fiveHundredHandler = new FiveHundredHandler(avgNumberOfNotes);
        IHandler hundredHandler = new HundredHandler(avgNumberOfNotes);

        this.handler.setHandler(fiveHundredHandler);
        fiveHundredHandler.setHandler(hundredHandler);
    }

    public void dispenseMoney(Integer amount) {
        try {
            System.out.println("Dispensing: " + amount);
            handler.dispense(amount);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }
    }
}
