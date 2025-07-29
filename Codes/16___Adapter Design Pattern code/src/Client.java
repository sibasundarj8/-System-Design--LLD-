public class Client {
    public static void main(String[] args) {
        StockDataProvider stock = new StockDataProvider();
        AnalyticLibrary analytics = new XmlToJsonAdaptor(stock);

        System.out.println(analytics.getAnalyticData());/*
         
         * xml data:
         *                  <stock>
         *                      <price>
         *                          1440
         *                      </price>
         *                  </stock>
         * json data:
         *                  {"stock":{"price":1440}}
         */
    }
}
