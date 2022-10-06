package com.example.sellers.domain.personalExceptions;

public class ClientNotFoundException extends Exception{
    public ClientNotFoundException(String message) {
        super("**ERROR**" + message);
    }
}
