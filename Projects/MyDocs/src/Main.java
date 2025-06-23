public class Main {
    public static void main(String[] args) {
        Persistence db = new FileStorage("MyInfo");
        DocumentEditor editor = new DocumentEditor(db);

        editor.addText("Welcome to MyDocs 🥳🎉🎊");
        editor.addNewLine();
        editor.addImage("sibasundar.jpg");
        editor.addNewLine();
        editor.addText("Hello, ");
        editor.addNewLine();
        editor.addTabSpace();
        editor.addText("I am Sibasundar Jena, and currently I am ");
        editor.addNewLine();
        editor.addTabSpace();
        editor.addText("making MyDocs app a real world LLD project.");
        editor.addNewLine();

        System.out.println(editor.renderDocument());
        editor.save(); // MyInfo.txt
    }
}