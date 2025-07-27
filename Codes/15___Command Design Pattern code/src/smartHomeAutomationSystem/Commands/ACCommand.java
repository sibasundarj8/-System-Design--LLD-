package smartHomeAutomationSystem.Commands;

import smartHomeAutomationSystem.Receiver.AC;

public class ACCommand implements ICommand {
    private final AC ac;

    public ACCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        this.ac.on();
    }

    @Override
    public void undo() {
        this.ac.off();
    }
}
