package com.villacamp.hn.excellence.exception;

public class InvalidLoginException extends RuntimeException {

    public InvalidLoginException(String msg) {
        super(msg);
    }
}
