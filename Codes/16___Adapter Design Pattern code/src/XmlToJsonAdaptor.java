public class XmlToJsonAdaptor implements AnalyticLibrary {
    private final StockDataProvider stock;

    public XmlToJsonAdaptor(StockDataProvider stock) {
        this.stock = stock;
    }

    @Override
    public String getAnalyticData() {
        String data = stock.getStockData();
        // conversion logic --> XML to JSON
        return """ 
                {"stock":{"price":1440}}""";
    }
}
