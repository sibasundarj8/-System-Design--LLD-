import protection_poxy.IDocReader;
import protection_poxy.Pdf;
import protection_poxy.ProxyDocReader;
import protection_poxy.User;
import remote_proxy.IDataService;
import remote_proxy.ProxyDataService;
import virtual_proxy.Image;
import virtual_proxy.ProxyImage;

public class Client {
    public static void main(String[] args) {

        // virtual proxy
        System.out.println("---------virtual-proxy---------");

        Image image = new ProxyImage("sibasundar.jpg");
        image.display();
        image.display();

        System.out.println("\n");


        // protection proxy
        System.out.println("--------protection-proxy-------");

        User user = new User("Sibasundar Jena");
        user.setPremium(true);
        IDocReader docReader = new ProxyDocReader(user);
        Pdf pdf = new Pdf("data.pdf", "Pass@123", "it is a secret message", true);
        docReader.display(pdf);
        Pdf unlockedPdf = docReader.unlockPdf(pdf, "Pass@123");
        docReader.display(unlockedPdf);

        System.out.println("\n");


        // remote proxy
        System.out.println("----------remote-proxy---------");

        IDataService dataService = new ProxyDataService();
        dataService.fetchData();

        System.out.println("\n");
    }
}
