package smartHomeAutomationSystem.Commands;

public interface ICommand {
    void execute();
    void undo();
}