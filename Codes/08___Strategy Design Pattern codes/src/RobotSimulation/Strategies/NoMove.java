package RobotSimulation.Strategies;

public class NoMove implements Movable {
    @Override
    public void move() {
        System.out.println("Can't Move");
    }
}