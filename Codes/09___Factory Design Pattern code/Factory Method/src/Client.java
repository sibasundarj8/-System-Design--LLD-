import Factory.BurgerFactory;
import Factory.KingBurgerFactory;
import Factory.SinghBurgerFactory;
import Product.Burger;

public class Client {
    public static void main(String[] args) {
        BurgerFactory kingFactory = new KingBurgerFactory();
        BurgerFactory singhFactory = new SinghBurgerFactory();
        Burger burger1 = kingFactory.createBurger("premium");
        Burger burger2 = singhFactory.createBurger("standard");
        burger1.prepare();
        burger2.prepare();
    }
}