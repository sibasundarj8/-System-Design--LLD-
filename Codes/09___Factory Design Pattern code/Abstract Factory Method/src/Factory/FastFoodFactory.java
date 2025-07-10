package Factory;

import Product.Burger;
import Product.Pizza;

public interface FastFoodFactory {
    Burger createBurger(String type);
    Pizza createPizza(String type);
}