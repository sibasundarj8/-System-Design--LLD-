package atmMachine.handler;

public class HundredHandler extends IHandler {

    public HundredHandler(Integer numberOfNotes) {
        super(numberOfNotes);
    }

    @Override
    public void dispense(int amount) {
        int requiredNotes = amount / 100;
        int requiredMoney = (requiredNotes <= numberOfNotes) ? amount % 100 : amount - numberOfNotes * 100;
        int usedNotes = Math.min(numberOfNotes, requiredNotes);

        if (requiredMoney > 0) {
            if (this.next == null) {
                throw new RuntimeException("⚠️ Insufficient cash in machine ⚠️");
            }
            this.next.dispense(requiredMoney);
        }

        numberOfNotes -= usedNotes;
        System.out.println(100 + " ⨉ " + usedNotes);
    }
}