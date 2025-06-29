package RobotSimulation;

import RobotSimulation.Strategies.Flyable;
import RobotSimulation.Strategies.Movable;
import RobotSimulation.Strategies.Talkable;

public class CrowRobot extends Robot {

    public CrowRobot(Movable m, Talkable t, Flyable f) {
        super(m, t, f);
    }

    @Override
    public void projection() {
        System.out.println("""
                Crow robot : Power | 40%
                             Brain | 20%
                             Speed | 45 km/h
                             Color | Black
                """);
    }
}