package Factory;

import Product.Burger;
import Product.BasicBurger;
import Product.PremiumBurger;
import Product.StandardBurger;

public class SinghBurgerFactory implements BurgerFactory {
    @Override
    public Burger createBurger(String type) {
        type = type.toLowerCase();
        switch (type) {
            case "basic" -> {
                return new BasicBurger();
            }
            case "standard" -> {
                return new StandardBurger();
            }
            case "premium" -> {
                return new PremiumBurger();
            }
            default -> throw new RuntimeException("Burger not found");
        }
    }
}