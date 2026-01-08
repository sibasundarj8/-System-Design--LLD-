import DiscountCouponEngine.DiscountCouponEngine;
import DiscountCouponEngine.Other.Cart;
import DiscountCouponEngine.Other.Product;

import java.util.List;

public class Client {
    /// <h2> main method
    public static void main(String[] args) {
        DiscountCouponEngine couponEngine = new DiscountCouponEngine();
        couponEngine.testEngine();

        // creating products
        Cart cart = getCart();

        // getting total amount
        System.out.println("Original cart Total: ₹" + cart.getTotalAmount());

        // getting the applicable coupons
        List<String> applicableCoupons = couponEngine.getApplicableCoupons(cart);

        System.out.println("Applicable Coupons: ");
        for (String coupon : applicableCoupons) {
            System.out.println(coupon);
        }

        couponEngine.applyAllCoupons(cart);

        System.out.println("Total amount after applying coupons: ₹" +  cart.getTotalAmount());
    }

    private static Cart getCart() {
        Product p1 = new Product("Winter Jacket", "Clothing", 966.00);
        Product p2 = new Product("Samsung F14", "Smartphone", 14999.00);
        Product p3 = new Product("MacBook M2", "Laptop", 63999.00);
        Product p4 = new Product("Headphone", "Electronics", 450.00);

        // setting up the cart
        Cart cart = new Cart();
        cart.setLoyaltyMember(true);
        cart.setPaymentBank("BOI");

        // adding product to cart
        cart.addProduct(p1, 2);
        cart.addProduct(p2, 1);
        cart.addProduct(p3, 1);
        cart.addProduct(p4, 1);

        return cart;
    }
}
