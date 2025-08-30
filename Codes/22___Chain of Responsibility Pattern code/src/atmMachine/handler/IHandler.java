package atmMachine.handler;

public abstract class IHandler {
    protected Integer numberOfNotes;
    protected IHandler next;

    public IHandler(Integer numberOfNotes) {
        this.numberOfNotes = numberOfNotes;
    }

    public abstract void dispense(int amount);

    public void setHandler(IHandler handler) {
        this.next = handler;
    }
}