package com.example.sellers.domain;

public class ExceptionInvalidParameter extends Exception{
    public ExceptionInvalidParameter(String message) {
        super("**ERROR**" + message);
    }
}
