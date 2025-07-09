package Product;

public class PremiumWheatBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("--preparing Premium Wheat Burger--");
    }
}