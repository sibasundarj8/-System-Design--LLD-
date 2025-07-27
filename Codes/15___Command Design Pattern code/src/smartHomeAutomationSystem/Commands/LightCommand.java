package smartHomeAutomationSystem.Commands;

import smartHomeAutomationSystem.Receiver.Light;

public class LightCommand implements ICommand {
    private final Light light;

    public LightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.on();
    }

    @Override
    public void undo() {
        this.light.off();
    }
}