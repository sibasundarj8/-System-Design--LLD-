package DiscountCouponEngine.Other;

import DiscountCouponEngine.utils.Money;

import java.math.BigDecimal;
import java.util.Objects;

public class CartItem {
    private final Product product;
    private Integer quantity;
    private BigDecimal price;

    public CartItem(Product product, Integer quantity) {
        this.quantity = quantity;
        this.product = product;
        this.price = Money.multiply(product.price(), BigDecimal.valueOf(quantity));
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        this.price = Money.multiply(product.price(), BigDecimal.valueOf(quantity));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(product, cartItem.product) || Objects.equals(product.name(), cartItem.product.name());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(product);
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "\n\tproduct=" + product +
                ", \n\tquantity=" + quantity +
                ", \n\tprice=" + price +
                "\n}";
    }
}