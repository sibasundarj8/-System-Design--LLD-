package DiscountCouponEngine;

import DiscountCouponEngine.Discount_Coupons.*;
import DiscountCouponEngine.Other.Cart;
import DiscountCouponEngine.managers.DiscountCouponManager;

import java.util.List;

public class DiscountCouponEngine {
    DiscountCouponManager couponManager = DiscountCouponManager.getInstance();

    public void registerCoupon(Coupon coupon) {
        couponManager.registerCoupon(coupon);
    }

    public void unregisterCoupon(Coupon coupon) {
        couponManager.unregisterCoupon(coupon);
    }

    public void applyAllCoupons(Cart cart) {
        couponManager.applyAllCoupons(cart);
    }

    public List<String> getApplicableCoupons(Cart cart) {
        return couponManager.getApplicableCoupons(cart);
    }

    public void testEngine() {
        // registering coupons
        Coupon c1 = new SeasonalCoupon(1L, "Clothing", 18.22);
        Coupon c2 = new LoyalityDiscountCoupon(2L, 2.00);
        Coupon c3 = new BulkPurchaseCoupon(3L, 1000.00, 100.00);
        Coupon c4 = new BankingCoupon(4L, "BOI", 2000.00, 5.00, 2000.00);

        this.registerCoupon(c1);
        this.registerCoupon(c2);
        this.registerCoupon(c3);
        this.registerCoupon(c4);

        this.unregisterCoupon(c3);
    }
}
