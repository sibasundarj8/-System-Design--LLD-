package DiscountCouponEngine.Discount_Coupons;

import DiscountCouponEngine.Discount_Strategies.DiscountStrategy;
import DiscountCouponEngine.Other.Cart;
import DiscountCouponEngine.enums.StrategyType;
import DiscountCouponEngine.managers.DiscountStrategyManager;
import DiscountCouponEngine.utils.Money;

import java.math.BigDecimal;

public class LoyalityDiscountCoupon extends Coupon {
    private final BigDecimal percentage;
    private final DiscountStrategy strategy;

    public LoyalityDiscountCoupon(Long id, Double percentage) {
        super(id);
        this.percentage = Money.of(BigDecimal.valueOf(percentage));
        this.strategy = DiscountStrategyManager
                .getInstance()
                .getDiscountStrategy(StrategyType.PERCENTAGE, this.percentage, BigDecimal.ZERO);
    }

    @Override
    public Boolean isApplicable(Cart cart) {
        return cart.isLoyaltyMember();
    }

    @Override
    public BigDecimal getDiscount(Cart cart) {
        return strategy.calculateDiscount(cart.getTotalAmount());
    }

    @Override
    public String name() {
        return "Loyalty discount " + percentage.intValue() + "% off";
    }
}