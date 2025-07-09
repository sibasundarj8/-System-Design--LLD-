package Factory;

import Product.Burger;

public interface BurgerFactory {
    Burger createBurger(String type);
}