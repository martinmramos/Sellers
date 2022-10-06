package com.example.sellers.domain.personalExceptions;

public class CarExistsException extends Exception{
    public CarExistsException(String message) {
        super("**ERROR**" + message);
    }
}
