public class ImageElement implements DocumentElements {
    private final String image;

    public ImageElement(String path) {
        this.image = path;
    }

    @Override
    public String render() {
        if (this.image.endsWith(".jpg") || this.image.endsWith(".png")) {
            return "[image:" + this.image + "]";
        }
        return "image not found";
    }
}