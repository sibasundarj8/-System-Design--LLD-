package RobotSimulation;

import RobotSimulation.Strategies.Flyable;
import RobotSimulation.Strategies.Movable;
import RobotSimulation.Strategies.Talkable;

public class CompanionRobot extends Robot {

    public CompanionRobot(Movable m, Talkable t, Flyable f) {
        super(m, t, f);
    }

    @Override
    public void projection() {
        System.out.println("""
                Companion robot : Power | 30%
                                  Brain | 100%
                """);
    }
}