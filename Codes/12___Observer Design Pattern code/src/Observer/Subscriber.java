package Observer;

import Observable.Channel;

public interface Subscriber {
    void update();
    void subscribe(Channel channel);
    void unsubscribe(Channel channel);
}
