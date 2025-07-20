package Observable;

import Observer.Subscriber;

public interface Channel {
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscriber();
    String getVideoTitle();
}
