package RobotSimulation;

import RobotSimulation.Strategies.Flyable;
import RobotSimulation.Strategies.Movable;
import RobotSimulation.Strategies.Talkable;

public class ParrotRobot extends Robot {

    public ParrotRobot(Movable m, Talkable t, Flyable f) {
        super(m, t, f);
    }

    @Override
    public void projection() {
        System.out.println("""
                Parrot robot : Power | 30%
                               Brain | 10%
                               Speed | 40 km/h
                               Color | Green
                """);
    }
}