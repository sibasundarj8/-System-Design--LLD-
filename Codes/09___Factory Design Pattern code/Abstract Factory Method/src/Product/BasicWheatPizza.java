package Product;

public class BasicWheatPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("🍕 Preparing Basic Wheat Pizza 🍕");
    }
}