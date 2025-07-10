package Factory;

import Product.*;

public class SinghFastFoodFactory implements FastFoodFactory {

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
            default -> throw new RuntimeException("Burger not found!!");
        }
    }

    @Override
    public Pizza createPizza(String type) {
        type = type.toLowerCase();

        switch (type) {
            case "basic" -> {
                return new BasicPizza();
            }
            case "cheese" -> {
                return new CheesePizza();
            }
            case "chicken" -> {
                return new ChickenPizza();
            }
            default -> throw new RuntimeException("Pizza not found!!");
        }
    }
}