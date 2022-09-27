package com.example.sellers.domain.personalExceptions;

public class StatusIncorrectException extends Exception{

    public StatusIncorrectException() {
        super("WRONG STATUS");
    }
}
