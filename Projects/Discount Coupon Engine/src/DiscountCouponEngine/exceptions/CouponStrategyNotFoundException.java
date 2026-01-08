package DiscountCouponEngine.exceptions;

public class CouponStrategyNotFoundException extends IllegalArgumentException {
    // noArgsConstructor
    public  CouponStrategyNotFoundException() {
        super();
    }
    // constructor with message.
    public CouponStrategyNotFoundException(String message) {
        super(message);
    }
}
