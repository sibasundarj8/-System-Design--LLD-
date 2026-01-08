package DiscountCouponEngine.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Money {

    private static final int SCALE = 2;
    private static final RoundingMode ROUNDING = RoundingMode.HALF_UP;

    private Money() {}

    public static BigDecimal of(BigDecimal value) {
        return value.setScale(SCALE, ROUNDING);
    }

    public static BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b).setScale(SCALE, ROUNDING);
    }

    public static BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b).setScale(SCALE, ROUNDING);
    }

    public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b).setScale(SCALE, ROUNDING);
    }

    public static BigDecimal divide(BigDecimal a, BigDecimal b) {
        return a.divide(b, SCALE, ROUNDING);
    }

    public static BigDecimal min(BigDecimal a, BigDecimal b) {
        return of(a.min(b));
    }

    public static BigDecimal max(BigDecimal a, BigDecimal b) {
        return of(a.max(b));
    }
}
