package Product;

public class CheeseWheatPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("🍕 Preparing Cheese Wheat Pizza 🍕");
    }
}