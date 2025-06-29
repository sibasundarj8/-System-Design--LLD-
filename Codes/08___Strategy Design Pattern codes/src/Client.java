import RobotSimulation.*;
import RobotSimulation.Strategies.*;

public class Client {
    public static void main(String[] args) {
        Robot companion = new CompanionRobot(            // Injecting strategies with requirements by constructor injection.
                new MoveByLeg(),      // moving strategy 
                new NormalTalk(),     // talking strategy
                new NoFly());         // flying strategy 
        Robot worker = new WorkerRobot(
                new MoveByWheel(),    // moving strategy 
                new NoTalk(),         // talking strategy
                new NoFly());         // flying strategy 
        Robot parrot = new ParrotRobot(
                new MoveByLeg(),      // moving strategy
                new NormalTalk(),     // talking strategy
                new FlyByWings());    // flying strategy 
        Robot crow = new CrowRobot(
                new MoveByLeg(),      // moving strategy 
                new NoTalk(),         // talking strategy
                new FlyByWings());    // flying strategy 

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
