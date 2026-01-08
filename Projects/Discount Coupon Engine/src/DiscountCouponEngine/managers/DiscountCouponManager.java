package DiscountCouponEngine.managers;

import DiscountCouponEngine.Discount_Coupons.Coupon;
import DiscountCouponEngine.Other.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiscountCouponManager {
    private static volatile DiscountCouponManager instance;
    private static final Lock lock = new ReentrantLock();
    private Coupon head;
    private Coupon tail;

    private DiscountCouponManager () {
    }

    public static DiscountCouponManager getInstance() {
        if (instance == null) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new DiscountCouponManager();
                }
            } finally {
                lock.unlock();
            }
        }

        return instance;
    }

    public void registerCoupon(Coupon coupon) {
        lock.lock();
        try {
            if (this.head == null) {
                this.head = coupon;
                this.tail = coupon;
            } else {
                tail.setNext(coupon);
                coupon.setPrevious(tail);
                tail = tail.getNext();
            }
        } finally {
            lock.unlock();
        }
    }

    public void unregisterCoupon(Coupon coupon) {
        lock.lock();
        try {
            if (head == null || coupon == null) return;

            // deleting head
            if (head.equals(coupon)) {
                Coupon temp = head;
                head = head.getNext();

                if (head != null) head.setPrevious(null);
                else tail = null;

                temp.setNext(null);
                temp.setPrevious(null);
                return;
            }

            // deleting tail
            if (tail.equals(coupon)) {
                Coupon temp = tail;
                tail = tail.getPrevious();
                tail.setNext(null);

                temp.setPrevious(null);
                temp.setNext(null);
                return;
            }

            // deleting from middle
            Coupon temp = head.getNext();
            while (temp != null) {
                if (temp.equals(coupon)) {
                    temp.getPrevious().setNext(temp.getNext());
                    temp.getNext().setPrevious(temp.getPrevious());

                    temp.setNext(null);
                    temp.setPrevious(null);
                    break;
                }
                temp = temp.getNext();
            }
        } finally {
            lock.unlock();
        }
    }

    public void applyAllCoupons(Cart cart) {
        lock.lock();
        try {
            if (this.head != null) {
                head.applyCoupon(cart);
            }
        } finally {
            lock.unlock();
        }
    }

    public List<String> getApplicableCoupons(Cart cart) {
        lock.lock();
        try {
            List<String> list = new ArrayList<>();
            Coupon head = this.head;

            while (head != null) {
                if (head.isApplicable(cart)) {
                    list.add(head.name());
                }
                head = head.getNext();
            }

            return list;
        } finally {
            lock.unlock();
        }
    }
}
