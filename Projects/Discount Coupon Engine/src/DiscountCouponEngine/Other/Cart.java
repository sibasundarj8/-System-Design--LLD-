package DiscountCouponEngine.Other;

import DiscountCouponEngine.utils.Money;

import java.math.BigDecimal;
import java.util.HashMap;

public class Cart {
    private final HashMap<Product, CartItem> cartItems;
    private Boolean loyaltyMember;
    private BigDecimal originalPrice;
    private BigDecimal discountedPrice;
    private String paymentBank;

    // constructor
    public Cart() {
        this.cartItems = new HashMap<>();
        this.loyaltyMember = false;
        this.originalPrice = Money.of(BigDecimal.ZERO);
        this.discountedPrice = Money.of(BigDecimal.ZERO);
    }

    // getters and setters
    public HashMap<Product, CartItem> getCartItems() {
        return this.cartItems;
    }

    public Boolean isLoyaltyMember() {
        return this.loyaltyMember;
    }

    public void setLoyaltyMember(Boolean loyaltyMember) {
        this.loyaltyMember = loyaltyMember;
    }

    public BigDecimal getOriginalPrice() {
        return this.originalPrice;
    }

    public BigDecimal getDiscountedPrice() {
        return this.discountedPrice;
    }

    public BigDecimal getTotalAmount() {
        return getOriginalPrice().subtract(getDiscountedPrice());
    }

    public String getPaymentBank() {
        return this.paymentBank;
    }

    public void setPaymentBank(String paymentBank) {
        this.paymentBank = paymentBank;
    }

    // other methods
    public void addProduct(Product product, Integer quantity) {
        if (quantity <= 0) return;
        CartItem cartItem;

        if (cartItems.containsKey(product)) cartItem = cartItems.get(product);
        else cartItem = new CartItem(product, 0);

        BigDecimal oldPrice = cartItem.getPrice();

        cartItem.setQuantity(cartItem.getQuantity() + quantity);
        this.cartItems.put(product, cartItem);

        BigDecimal newPrice = Money.multiply(product.price(), BigDecimal.valueOf(cartItem.getQuantity()));

        this.originalPrice = Money.add(this.originalPrice, Money.subtract(newPrice, oldPrice));
        discountedPrice = Money.of(BigDecimal.ZERO);
    }

    public void removeProduct(Product product) {
        if (product == null) return;
        CartItem cartItem = this.cartItems.get(product);

        if (cartItem != null) {
            this.cartItems.remove(product);
            originalPrice = Money.subtract(originalPrice, cartItem.getPrice());
            discountedPrice = Money.of(BigDecimal.ZERO);
        }
    }

    public void applyDiscount(BigDecimal discount) {
        if (discount.intValue() <= 0) return;
        discountedPrice = Money.add(discountedPrice, discount);
    }

    public void clearCart() {
        this.cartItems.clear();
        this.originalPrice = Money.of(BigDecimal.ZERO);
    }
}
