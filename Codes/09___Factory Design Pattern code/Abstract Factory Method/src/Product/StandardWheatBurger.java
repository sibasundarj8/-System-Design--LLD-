package Product;

public class StandardWheatBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("🍔 Preparing Standard Wheat Burger🍔");
    }
}