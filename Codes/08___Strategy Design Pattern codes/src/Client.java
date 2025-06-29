import RobotSimulation.*;
import RobotSimulation.Strategies.*;

public class Client {
    public static void main(String[] args) {
        Robot companion = new CompanionRobot(
                new MoveByLeg(),
                new NormalTalk(),
                new NoFly());
        Robot worker = new WorkerRobot(
                new MoveByWheel(),
                new NoTalk(),
                new NoFly());
        Robot parrot = new ParrotRobot(
                new MoveByLeg(),
                new NormalTalk(),
                new FlyByWings());
        Robot crow = new CrowRobot(
                new MoveByLeg(),
                new NoTalk(),
                new FlyByWings());

        companion.projection();
        worker.projection();
        parrot.projection();
        crow.projection();

        companion.move();
        worker.move();
        parrot.talk();
        crow.fly();
    }
}