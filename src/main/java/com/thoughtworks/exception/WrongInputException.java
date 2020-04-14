package com.thoughtworks.exception;

public class WrongInputException extends Exception{
    public WrongInputException() {
        super();
    }

    public WrongInputException(String message) {
        super(message);
    }
}
