package com.example.sellers.domain.personalExceptions;

public class ExceptionInvalidParameter extends Exception{
    public ExceptionInvalidParameter(String message) {
        super("**ERROR**" + message);
    }
}
