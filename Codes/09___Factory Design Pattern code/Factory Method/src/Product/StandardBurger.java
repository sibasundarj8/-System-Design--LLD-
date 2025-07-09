package Product;

public class StandardBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("--preparing Standard Burger--");
    }
}