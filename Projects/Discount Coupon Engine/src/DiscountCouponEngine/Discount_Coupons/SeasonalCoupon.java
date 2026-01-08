package DiscountCouponEngine.Discount_Coupons;

import DiscountCouponEngine.Discount_Strategies.DiscountStrategy;
import DiscountCouponEngine.Other.Cart;
import DiscountCouponEngine.enums.StrategyType;
import DiscountCouponEngine.managers.DiscountStrategyManager;
import DiscountCouponEngine.utils.Money;

import java.math.BigDecimal;
import java.util.Objects;

public class SeasonalCoupon extends Coupon {
    private final String category;
    private final BigDecimal percentage;
    private final DiscountStrategy strategy;

    public SeasonalCoupon(Long id, String category, Double percentage) {
        super(id);
        this.category = category;
        this.percentage = Money.of(BigDecimal.valueOf(percentage));
        this.strategy = DiscountStrategyManager
                .getInstance()
                .getDiscountStrategy(StrategyType.PERCENTAGE, this.percentage, BigDecimal.ZERO);
    }

    @Override
    public Boolean isApplicable(Cart cart) {
        return cart.getCartItems()
                .keySet()
                .stream()
                .anyMatch(a -> Objects.equals(a.category(), category));
    }

    @Override
    public BigDecimal getDiscount(Cart cart) {
        return cart.getCartItems()
                .values()
                .stream()
                .filter(p -> p.getProduct().category().equals(category))
                .map(p -> strategy.calculateDiscount(p.getPrice()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public String name() {
        return "Seasonal offer " + percentage.intValue() + "% off on " + category;
    }
}