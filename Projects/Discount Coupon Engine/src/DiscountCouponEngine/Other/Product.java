package DiscountCouponEngine.Other;

import DiscountCouponEngine.utils.Money;

import java.math.BigDecimal;

public class Product {
    private final String name;
    private final String category;
    private BigDecimal price;

    public Product(String name, String category, Double price) {
        this.name = name;
        this.category = category;
        this.price = Money.of(BigDecimal.valueOf(price));
    }

    public String name() {
        return name;
    }

    public String category() {
        return category;
    }

    public BigDecimal price() {
        return price;
    }
}