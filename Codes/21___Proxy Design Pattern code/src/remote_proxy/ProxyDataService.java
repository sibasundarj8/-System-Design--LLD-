package remote_proxy;

public class ProxyDataService implements IDataService {
    private RealDataService dataService;

    @Override
    public void fetchData() {
        buildConnection();
        dataService.fetchData();
    }

    // connecting to a remote server (protocols, networks, and other complexities)
    private void buildConnection() {
        System.out.println("[ProxyDataServer]: Connecting to server...");
        this.dataService = new RealDataService();
    }
}