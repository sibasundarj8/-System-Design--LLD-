package smartHomeAutomationSystem;

import smartHomeAutomationSystem.Commands.ICommand;

public class RemoteControl {
    private final int numberOfButtons = 4;
    private final ICommand[] buttons;
    private final Boolean[] flag;

    public RemoteControl() {
        this.buttons = new ICommand[numberOfButtons];
        this.flag = new Boolean[numberOfButtons];
    }

    public void setCommand(int idx, ICommand command) {
        if (idx < 0 || numberOfButtons <= idx) {
            System.out.println("No command assigned at button: " + idx);
            return;
        }
        buttons[idx] = command;
        flag[idx] = false;
    }

    public void pressButton(int idx) {
        if (idx < 0 || numberOfButtons <= idx || buttons[idx] == null) {
            System.out.println("No command assigned at button: " + idx);
            return;
        }
        if (flag[idx]) {
            buttons[idx].undo();
            flag[idx] = false;
        } else {
            buttons[idx].execute();
            flag[idx] = true;
        }
    }
}
