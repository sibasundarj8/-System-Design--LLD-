package RobotSimulation.Strategies;

public class NoTalk implements Talkable {
    @Override
    public void talk() {
        System.out.println("Can't Talk");
    }
}