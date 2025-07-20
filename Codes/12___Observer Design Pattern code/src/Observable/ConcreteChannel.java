package Observable;

import Observer.Subscriber;

import java.util.LinkedList;
import java.util.List;

public class ConcreteChannel implements Channel {
    private final String name;
    private String latestVideo;
    private final List<Subscriber> subscribers;

    // constructor
    public ConcreteChannel(String name) {
        this.name = name;
        this.subscribers = new LinkedList<>();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        if (!subscribers.contains(subscriber)) {
            this.subscribers.add(subscriber);
        }
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        if (subscribers.contains(subscriber)) {
            this.subscribers.remove(subscriber);
        }
    }

    @Override
    public void notifySubscriber() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }

    public void upload(String videoTitle) {
        this.latestVideo = videoTitle;
        System.out.println("\n[" + this.name + " uploaded- " + videoTitle + "]");
        this.notifySubscriber();
    }

    @Override
    public String getVideoTitle() {
        return "Checkout our new video: " + this.latestVideo;
    }
}
