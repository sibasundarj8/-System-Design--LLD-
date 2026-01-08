package DiscountCouponEngine.Discount_Coupons;

import DiscountCouponEngine.Other.Cart;

import java.math.BigDecimal;

public abstract class Coupon {
    private final Long id;
    private Coupon next;
    private Coupon previous;

    protected Coupon(Long id) {
        this.id = id;
    }

    public void setNext(Coupon coupon) {
        this.next = coupon;
    }

    public Coupon getNext() {
        return next;
    }

    public void setPrevious(Coupon coupon) {
        this.previous = coupon;
    }

    public Coupon getPrevious() {
        return previous;
    }

    public void applyCoupon(Cart cart) {
        if (isApplicable(cart)) {
            BigDecimal discount = getDiscount(cart);
            cart.applyDiscount(discount);
            System.out.println(name() + " applied: " + discount + "/-");
            if (!isCombinable(cart)) return;
        }
        if (next != null) {
            next.applyCoupon(cart);
        }
    }

    public Boolean isCombinable(Cart cart) {
        return true;
    }

    public abstract Boolean isApplicable(Cart cart);

    public abstract BigDecimal getDiscount(Cart cart);

    public abstract String name();
}