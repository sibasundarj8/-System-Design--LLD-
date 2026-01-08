package DiscountCouponEngine.Discount_Strategies;

import DiscountCouponEngine.utils.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PercentageWithCapDiscountStrategy implements DiscountStrategy {
    private final BigDecimal capacity;
    private final BigDecimal percentage;

    public PercentageWithCapDiscountStrategy(BigDecimal percentage, BigDecimal capacity) {
        this.percentage = percentage;
        this.capacity = Money.of(capacity);
    }

    @Override
    public BigDecimal calculateDiscount(BigDecimal baseAmount) {
        BigDecimal percent = percentage.divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
        BigDecimal discount = Money.of(baseAmount.multiply(percent));
        return Money.min(capacity, discount);
    }
}