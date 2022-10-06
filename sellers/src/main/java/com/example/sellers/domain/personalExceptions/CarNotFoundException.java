package com.example.sellers.domain.personalExceptions;

public class CarNotFoundException extends Exception{
    public CarNotFoundException(String message) {
        super("**ERROR**" + message);
    }
}
