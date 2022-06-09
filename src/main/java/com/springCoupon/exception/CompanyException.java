package com.springCoupon.exception;

public class CompanyException extends Exception {

    String exception;

    public CompanyException(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return "your exception is: " + exception;
    }
}

