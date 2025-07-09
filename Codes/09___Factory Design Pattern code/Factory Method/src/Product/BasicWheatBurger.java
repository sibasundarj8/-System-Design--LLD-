package Product;

public class BasicWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("--preparing Basic Wheat Burger--");
    }
}