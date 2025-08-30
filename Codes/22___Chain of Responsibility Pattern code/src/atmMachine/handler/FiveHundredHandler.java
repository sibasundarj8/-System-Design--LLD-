package atmMachine.handler;

public class FiveHundredHandler extends IHandler {

    public FiveHundredHandler(Integer numberOfNotes) {
        super(numberOfNotes);
    }

    @Override
    public void dispense(int amount) {
        int requiredNotes = amount / 500;
        int requiredMoney = (requiredNotes <= numberOfNotes) ? amount % 500 : amount - numberOfNotes * 500;
        int usedNotes = Math.min(numberOfNotes, requiredNotes);

        if (requiredMoney > 0) {
            if (this.next == null) {
                throw new RuntimeException("⚠️ Insufficient cash in machine ⚠️");
            }
            this.next.dispense(requiredMoney);
        }

        numberOfNotes -= usedNotes;
        System.out.println(500 + " ⨉ " + usedNotes);
    }
}
