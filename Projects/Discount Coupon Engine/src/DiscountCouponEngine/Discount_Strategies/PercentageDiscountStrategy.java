package DiscountCouponEngine.Discount_Strategies;

import DiscountCouponEngine.utils.Money;

import java.math.BigDecimal;

public class PercentageDiscountStrategy implements DiscountStrategy {
    private final BigDecimal percentage;

    public PercentageDiscountStrategy(BigDecimal percentage) {
        this.percentage = Money.of(percentage);
    }

    @Override
    public BigDecimal calculateDiscount(BigDecimal baseAmount) {
        double percent = percentage.doubleValue() / 100;
        double discount = baseAmount.doubleValue() * percent;
        return Money.of(BigDecimal.valueOf(discount));
    }
}