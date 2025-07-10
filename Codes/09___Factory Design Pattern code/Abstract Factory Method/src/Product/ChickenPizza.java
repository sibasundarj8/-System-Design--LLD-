package Product;

public class ChickenPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("🍕 Preparing Chicken Pizza 🍕");
    }
}