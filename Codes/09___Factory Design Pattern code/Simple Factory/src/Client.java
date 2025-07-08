import Factory.BurgerFactory;
import Product.Burger;

public class Client {
    public static void main(String[] args) {
        BurgerFactory factory = new BurgerFactory();
        Burger burger = factory.createBurger("premium");
        burger.prepare();
    }
}