package RobotSimulation;

import RobotSimulation.Strategies.Flyable;
import RobotSimulation.Strategies.Movable;
import RobotSimulation.Strategies.Talkable;

public abstract class Robot {
    private final Movable m;
    private final Talkable t;
    private final Flyable f;

    // constructor injection
    public Robot (Movable m, Talkable t, Flyable f) {
        this.m = m;
        this.t = t;
        this.f = f;
    }

    public void move() {
        m.move();
    }
    public void talk() {
        t.talk();
    }
    public void fly() {
        f.fly();
    }
    public abstract void projection();
}