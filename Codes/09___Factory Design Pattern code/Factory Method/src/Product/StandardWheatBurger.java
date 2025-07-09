package Product;

public class StandardWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("--preparing Standard Wheat Burger--");
    }
}