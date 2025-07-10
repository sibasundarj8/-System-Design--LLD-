package Factory;

import Product.*;

public class KingFastFoodFactory implements FastFoodFactory {

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
                return new PrimumWheatBurger();
            }
            default -> throw new RuntimeException("Burger not found!!");
        }
    }

    @Override
    public Pizza createPizza(String type) {
        type = type.toLowerCase();

        switch (type) {
            case "basic" -> {
                return new BasicWheatPizza();
            }
            case "cheese" -> {
                return new CheeseWheatPizza();
            }
            case "chicken" -> {
                return new ChickenWheatPizza();
            }
            default -> throw new RuntimeException("Pizza not found!!");
        }
    }
}