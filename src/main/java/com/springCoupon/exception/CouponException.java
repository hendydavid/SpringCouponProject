package com.springCoupon.exception;

public class CouponException extends Exception {

    String exception;

    public CouponException(String exception) {
        this.exception = exception;
    }


    public String getException() {
        return "your exception is: " + exception;
    }
}

