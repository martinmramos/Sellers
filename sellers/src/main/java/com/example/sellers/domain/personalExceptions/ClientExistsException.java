package com.example.sellers.domain.personalExceptions;

public class ClientExistsException extends Exception{
    public ClientExistsException(String message) {
        super("**ERROR**" + message);
    }
}
