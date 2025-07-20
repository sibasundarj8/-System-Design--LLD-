package Observer;

import Observable.Channel;

public class ConcreteSubscriber implements Subscriber {
    private final String name;
    private Channel channel;

    // constructor
    public ConcreteSubscriber(String name) {
        this.name = name;
    }

    // getter
    public String getName() {
        return name;
    }

    public Channel getChannel() {
        return channel;
    }

    @Override
    public void update() {
        System.out.println("Notification: Hey " + this.name + ", " + this.channel.getVideoTitle());
    }

    @Override
    public void subscribe(Channel channel) {
        channel.addSubscriber(this);
        this.channel = channel;
    }

    @Override
    public void unsubscribe(Channel channel) {
        channel.removeSubscriber(this);
        this.channel = null;
    }
}
