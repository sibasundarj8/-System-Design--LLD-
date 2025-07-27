package smartHomeAutomationSystem.Commands;

import smartHomeAutomationSystem.Receiver.Fan;

public class FanCommand implements ICommand {
    private final Fan fan;

    public FanCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        this.fan.start();
    }

    @Override
    public void undo() {
        this.fan.stop();
    }
}