package DiscountCouponEngine.managers;

import DiscountCouponEngine.Discount_Strategies.DiscountStrategy;
import DiscountCouponEngine.Discount_Strategies.FlatDiscountStrategy;
import DiscountCouponEngine.Discount_Strategies.PercentageDiscountStrategy;
import DiscountCouponEngine.Discount_Strategies.PercentageWithCapDiscountStrategy;
import DiscountCouponEngine.enums.StrategyType;
import DiscountCouponEngine.exceptions.CouponStrategyNotFoundException;

import java.math.BigDecimal;

public class DiscountStrategyManager {
    private static volatile DiscountStrategyManager instance;

    private DiscountStrategyManager() {}

    public static DiscountStrategyManager getInstance() {
        if (instance == null) {
            synchronized (DiscountStrategyManager.class) {
                if (instance == null) {
                    instance = new DiscountStrategyManager();
                }
            }
        }

        return instance;
    }

    public DiscountStrategy getDiscountStrategy(StrategyType strategyType, BigDecimal param1, BigDecimal param2) {
        DiscountStrategy strategy;

        switch (strategyType) {
            case FLAT -> strategy = new FlatDiscountStrategy(param1);
            case PERCENTAGE -> strategy = new PercentageDiscountStrategy(param1);
            case PERCENTAGE_WITH_CAP -> strategy = new PercentageWithCapDiscountStrategy(param1, param2);
            default -> throw new CouponStrategyNotFoundException("Select a Valid Strategy Type!!");
        }

        return strategy;
    }
}