package com.example.sellers.domain.personalExceptions;

public class SellerExistsException extends Exception{
    public SellerExistsException(String message) {
        super("**ERROR**" + message);
    }
}
