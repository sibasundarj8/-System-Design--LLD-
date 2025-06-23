public class TextElement implements DocumentElements{
    private final String text;

    public TextElement (String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
}