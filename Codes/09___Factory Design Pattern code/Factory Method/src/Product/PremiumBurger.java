package Product;

public class PremiumBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("--preparing Premium Burger--");
    }
}