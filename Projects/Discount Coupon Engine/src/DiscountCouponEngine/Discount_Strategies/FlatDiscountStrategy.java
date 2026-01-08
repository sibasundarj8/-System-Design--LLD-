package DiscountCouponEngine.Discount_Strategies;

import DiscountCouponEngine.utils.Money;

import java.math.BigDecimal;

public class FlatDiscountStrategy implements DiscountStrategy{
    private final BigDecimal amount;

    public FlatDiscountStrategy(BigDecimal amount) {
        this.amount = Money.of(amount);
    }

    @Override
    public BigDecimal calculateDiscount(BigDecimal baseAmount) {
        return Money.min(baseAmount, amount);
    }
}