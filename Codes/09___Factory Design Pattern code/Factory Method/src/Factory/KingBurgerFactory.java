package Factory;

import Product.Burger;
import Product.BasicWheatBurger;
import Product.PremiumWheatBurger;
import Product.StandardWheatBurger;

public class KingBurgerFactory implements BurgerFactory {
    @Override
    public Burger createBurger(String type) {
        type = type.toLowerCase();
        switch (type) {
            case "basic" -> {
                return new BasicWheatBurger();
            }
            case "standard" -> {
                return new StandardWheatBurger();
            }
            case "premium" -> {
                return new PremiumWheatBurger();
            }
            default -> throw new RuntimeException("Burger not found");
        }
    }
}