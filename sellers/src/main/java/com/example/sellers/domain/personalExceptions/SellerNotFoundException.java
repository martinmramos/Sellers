package com.example.sellers.domain.personalExceptions;

public class SellerNotFoundException extends Exception{
    public SellerNotFoundException(String message) {
        super("**ERROR**" + message);
    }
}
