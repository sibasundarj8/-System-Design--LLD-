import Factory.FastFoodFactory;
import Factory.KingFastFoodFactory;
import Factory.SinghFastFoodFactory;
import Product.Burger;
import Product.Pizza;

public class Client {
    public static void main(String[] args) {
        String burgerType = "standard";
        String pizzaType = "chicken";

        FastFoodFactory factory1 = new SinghFastFoodFactory();
        FastFoodFactory factory2 = new KingFastFoodFactory();

        Burger burger = factory1.createBurger(burgerType);
        Pizza pizza = factory2.createPizza(pizzaType);

        burger.prepare();
        pizza.prepare();
    }
}
