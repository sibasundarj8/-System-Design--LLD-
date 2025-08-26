package protection_poxy;

public class ProxyDocReader implements IDocReader {
    private final RealDocReader docReader;
    private final User user;

    public ProxyDocReader(User user) {
        this.user = user;
        this.docReader = new RealDocReader();
    }

    @Override
    public Pdf unlockPdf(Pdf pdf, String password) {
        if (user.isPremium()) {
            return docReader.unlockPdf(pdf, pdf.password());
        } else {
            throw new RuntimeException("🙁 Upgrade Doc Reader for premium features.");
        }
    }

    @Override
    public void display(Pdf pdf) {
        docReader.display(pdf);
    }
}