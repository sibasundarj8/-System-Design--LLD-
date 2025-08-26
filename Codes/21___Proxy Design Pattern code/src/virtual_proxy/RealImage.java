package virtual_proxy;

public class RealImage implements Image {
    private final String path;

    public RealImage(String path) {
        this.path = path;
        System.out.println("[Real Image]: Loading...");
    }

    @Override
    public void display() {
        System.out.println("[Real Image]: {" + path + "}");
    }
}