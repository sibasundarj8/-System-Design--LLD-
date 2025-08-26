package protection_poxy;

public interface IDocReader {
    Pdf unlockPdf(Pdf pdf, String password);
    void display(Pdf pdf);
}
