package Product;

public class ChickenWheatPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("🍕 Preparing Chicken Wheat Pizza 🍕");
    }
}