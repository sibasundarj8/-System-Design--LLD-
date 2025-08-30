package atmMachine.handler;

public class ThousandHandler extends IHandler {

    public ThousandHandler(Integer numberOfNotes) {
        super(numberOfNotes);
    }

    @Override
    public void dispense(int amount) {
        int requiredNotes = amount / 1000;
        int requiredMoney = (requiredNotes <= numberOfNotes) ? amount % 1000 : amount - numberOfNotes * 1000;
        int usedNotes = Math.min(numberOfNotes, requiredNotes);

        if (requiredMoney > 0) {
            if (this.next == null) {
                throw new RuntimeException("⚠️ Insufficient cash in machine ⚠️");
            }
            this.next.dispense(requiredMoney);
        }

        numberOfNotes -= usedNotes;
        System.out.println(1000 + " ⨉ " + usedNotes);
    }
}