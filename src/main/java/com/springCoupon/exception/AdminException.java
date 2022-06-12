package com.springCoupon.exception;

public class AdminException extends Exception {

    String exception;

    public AdminException(String exception) {
        this.exception = exception;
    }


    public String getException() {
        return "your exception is: " + exception;
    }
}

