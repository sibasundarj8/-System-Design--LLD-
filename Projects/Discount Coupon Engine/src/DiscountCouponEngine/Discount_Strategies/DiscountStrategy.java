package DiscountCouponEngine.Discount_Strategies;

import java.math.BigDecimal;

public interface DiscountStrategy {
    BigDecimal calculateDiscount(BigDecimal amount);
}
