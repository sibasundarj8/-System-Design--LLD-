import Observable.ConcreteChannel;
import Observer.ConcreteSubscriber;
import Observer.Subscriber;

public class Client {
    public static void main(String[] args) {
        // creating channel
        ConcreteChannel channel = new ConcreteChannel("Coder Army");

        // creating user
        Subscriber sub1 = new ConcreteSubscriber("Siba");
        Subscriber sub2 = new ConcreteSubscriber("Rahul");

        // user subscribes channel
        sub1.subscribe(channel);
        sub2.subscribe(channel);

        // channel uploads video
        channel.upload("Strategy Design Pattern");

        // user unsubscribes channel
        sub1.unsubscribe(channel);

        // channel uploads another video
        channel.upload("Factory Method Design Pattern");
    }
}
