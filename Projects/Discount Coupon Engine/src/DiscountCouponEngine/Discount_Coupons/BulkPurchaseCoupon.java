package DiscountCouponEngine.Discount_Coupons;

import DiscountCouponEngine.Discount_Strategies.DiscountStrategy;
import DiscountCouponEngine.Other.Cart;
import DiscountCouponEngine.enums.StrategyType;
import DiscountCouponEngine.managers.DiscountStrategyManager;
import DiscountCouponEngine.utils.Money;

import java.math.BigDecimal;

public class BulkPurchaseCoupon extends Coupon {
    private final BigDecimal threshold;
    private final BigDecimal flatOff;
    private final DiscountStrategy strategy;

    public BulkPurchaseCoupon(Long id, Double threshold, Double flatOff) {
        super(id);
        this.threshold = Money.of(BigDecimal.valueOf(threshold));
        this.flatOff = Money.of(BigDecimal.valueOf(flatOff));
        this.strategy = DiscountStrategyManager
                .getInstance()
                .getDiscountStrategy(StrategyType.FLAT, this.flatOff, BigDecimal.ZERO);
    }

    /// <H3> a <= b ---> a.compareTo(b) <= 0 </H3>
    @Override
    public Boolean isApplicable(Cart cart) {
        return this.threshold.compareTo(cart.getTotalAmount()) <= 0;
    }

    @Override
    public BigDecimal getDiscount(Cart cart) {
        return strategy.calculateDiscount(cart.getTotalAmount());
    }

    @Override
    public String name() {
        return "Bulk purchase Rs " + flatOff.intValue() + " off over " + threshold.intValue();
    }
}