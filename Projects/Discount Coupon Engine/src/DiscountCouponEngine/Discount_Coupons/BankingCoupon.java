package DiscountCouponEngine.Discount_Coupons;

import DiscountCouponEngine.Discount_Strategies.DiscountStrategy;
import DiscountCouponEngine.Other.Cart;
import DiscountCouponEngine.enums.StrategyType;
import DiscountCouponEngine.managers.DiscountStrategyManager;
import DiscountCouponEngine.utils.Money;

import java.math.BigDecimal;

public class BankingCoupon extends Coupon {
    private final String bank;
    private final BigDecimal minimumSpend;
    private final BigDecimal percentage;
    private final BigDecimal offset;
    private final DiscountStrategy discountStrategy;

    public BankingCoupon(Long id, String bank, Double minimumSpend, Double percentage, Double offset) {
        super(id);
        this.bank = bank;
        this.minimumSpend = Money.of(BigDecimal.valueOf(minimumSpend));
        this.percentage = Money.of(BigDecimal.valueOf(percentage));
        this.offset = Money.of(BigDecimal.valueOf(offset));
        this.discountStrategy = DiscountStrategyManager
                .getInstance()
                .getDiscountStrategy(StrategyType.PERCENTAGE_WITH_CAP, this.percentage, this.offset);
    }

    /// <H3> a > b ---> a.compareTo(b) > 0 </H3>
    @Override
    public Boolean isApplicable(Cart cart) {
        return (bank.equals(cart.getPaymentBank()) && cart.getTotalAmount().compareTo(minimumSpend) > 0);
    }

    @Override
    public Boolean isCombinable(Cart cart) {
        return false;
    }

    @Override
    public BigDecimal getDiscount(Cart cart) {
        return discountStrategy.calculateDiscount(cart.getTotalAmount());
    }

    @Override
    public String name() {
        return bank + " Bank Rs " + percentage.intValue() + "% off upto " + offset.intValue();
    }
}
