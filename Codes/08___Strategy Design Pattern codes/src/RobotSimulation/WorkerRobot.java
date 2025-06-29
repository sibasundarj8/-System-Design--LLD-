package RobotSimulation;

import RobotSimulation.Strategies.Flyable;
import RobotSimulation.Strategies.Movable;
import RobotSimulation.Strategies.Talkable;

public class WorkerRobot extends Robot {

    public WorkerRobot(Movable m, Talkable t, Flyable f) {
        super(m, t, f);
    }

    @Override
    public void projection() {
        System.out.println("""
                Worker robot : Power | 100%
                               Brain | 20%
                """);
    }
}