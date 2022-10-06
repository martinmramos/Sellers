package com.example.sellers.domain.personalExceptions;

public class BookingExistsException extends Exception{
    public BookingExistsException(String message) {
        super("**ERROR**" + message);
    }

}
