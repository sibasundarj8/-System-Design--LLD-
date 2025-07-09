package Product;

public class BasicBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("--preparing Basic Burger--");
    }
}