package virtual_proxy;

public class ProxyImage implements Image {
    private RealImage realImage;
    private final String path;

    public ProxyImage(String path) {
        this.path = path;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(path);
        }

        realImage.display();
    }
}