public class DocumentEditor {
    private final Document document;
    private final Persistence db;
    private String renderedDocument;

    // constructor injection (dependency injection through constructor)
    public DocumentEditor(Persistence db) {
        this.document = new Document();
        this.db = db;
        this.renderedDocument = "";
    }

    // add Text
    public void addText(String text) {
        document.addElement(new TextElement(text));
    }

    // add Image
    public void addImage(String path) {
        document.addElement(new ImageElement(path));
    }

    // add new line
    public void addNewLine() {
        document.addElement(new NewLineElement());
    }

    // add Space Tab
    public void addTabSpace() {
        document.addElement(new TabSpaceElement());
    }

    // render the document
    public String renderDocument() {
        if (this.renderedDocument.isEmpty()) {
            this.renderedDocument = document.render();
        }
        return this.renderedDocument;
    }

    // save to provided database
    public void save() {
        this.db.save(this.renderDocument());
    }
}