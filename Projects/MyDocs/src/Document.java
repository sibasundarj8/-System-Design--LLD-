import java.util.LinkedList;
import java.util.List;

public class Document {
    // has a relationship (1 to many)
    private final List<DocumentElements> elements;

    Document () {
        this.elements = new LinkedList<>();
    }

    // add new elements to the Document
    public void addElement (DocumentElements element) {
        this.elements.add(element);
    }

    // render the whole Document
    public String render () {
        StringBuilder renderedDocument = new StringBuilder();
        for (var ele : this.elements) {
            renderedDocument.append(ele.render());
        }
        return renderedDocument.toString();
    }
}