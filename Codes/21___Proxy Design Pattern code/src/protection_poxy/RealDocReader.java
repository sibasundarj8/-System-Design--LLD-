package protection_poxy;

public class RealDocReader implements IDocReader {

    @Override
    public Pdf unlockPdf(Pdf pdf, String password) {
        if (pdf.password().equals(password)) {
            String name = pdf.name();
            String content = pdf.content();
            return new Pdf(name, "", content, false);
        } else {
            throw new RuntimeException("⚠️ Incorrect password !!");
        }
    }

    @Override
    public void display(Pdf pdf) {
        if (!pdf.isProtected()) {
            System.out.println("[PDF]: " + pdf.content());
        } else {
            System.out.println("[PDF]: password protected !!");
        }
    }
}