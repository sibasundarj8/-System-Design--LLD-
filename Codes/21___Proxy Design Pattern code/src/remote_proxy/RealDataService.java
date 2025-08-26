package remote_proxy;

public class RealDataService implements IDataService {

    @Override
    public void fetchData() {
        System.out.println("[RealDataServer]: Data from server...");
    }
}