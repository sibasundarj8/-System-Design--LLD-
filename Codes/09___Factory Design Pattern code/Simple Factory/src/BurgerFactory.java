package Factory;

import Product.BasicBurger;
import Product.Burger;
import Product.PremiumBurger;
import Product.StandardBurger;

public class BurgerFactory {

    public Burger createBurger (String type) {
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