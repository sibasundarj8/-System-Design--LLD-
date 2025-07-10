package Product;

public class BasicPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("🍕 Preparing Basic Pizza 🍕");
    }
}