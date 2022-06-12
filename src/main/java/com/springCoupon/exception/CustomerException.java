package com.springCoupon.exception;

public class CustomerException extends Exception {

    String exception;

    public CustomerException(String exception) {
        this.exception = exception;
    }


    public String getException() {
        return "your exception is: " + exception;
    }
}

