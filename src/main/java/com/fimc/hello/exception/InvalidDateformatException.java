package com.fimc.hello.exception;

public class InvalidDateformatException extends RuntimeException {

    public InvalidDateformatException(String message) {
        super(message);
    }
}
