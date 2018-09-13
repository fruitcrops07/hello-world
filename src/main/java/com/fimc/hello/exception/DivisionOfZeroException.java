package com.fimc.hello.exception;

public class DivisionOfZeroException extends RuntimeException {

    public DivisionOfZeroException(String message) {
        super(message);
    }
}
