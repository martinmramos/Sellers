package com.example.sellers.domain.personalExceptions;

public class BookingNotFoundException extends Exception{
    public BookingNotFoundException(String message) {
        super("**ERROR**" + message);
    }
}
