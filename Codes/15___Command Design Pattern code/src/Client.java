import smartHomeAutomationSystem.Commands.ACCommand;
import smartHomeAutomationSystem.Commands.FanCommand;
import smartHomeAutomationSystem.Commands.LightCommand;
import smartHomeAutomationSystem.Receiver.AC;
import smartHomeAutomationSystem.Receiver.Fan;
import smartHomeAutomationSystem.Receiver.Light;
import smartHomeAutomationSystem.RemoteControl;

public class Client {
    public static void main(String[] args) {
        // setting devices
        Light light = new Light();
        Fan fan = new Fan();
        AC ac = new AC();

        // initializing Remote
        RemoteControl remote = new RemoteControl();

        // setting commands
        remote.setCommand(0, new LightCommand(light));
        remote.setCommand(1, new FanCommand(fan));
        remote.setCommand(2, new ACCommand(ac));

        // controlling
        remote.pressButton(0);
        remote.pressButton(0);

        remote.pressButton(1);
        remote.pressButton(1);

        remote.pressButton(2);
        remote.pressButton(2);

        remote.pressButton(3);
    }
}
