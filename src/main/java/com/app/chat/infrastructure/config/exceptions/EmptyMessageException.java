package com.app.chat.infrastructure.config.exceptions;

public class EmptyMessageException extends RuntimeException {
    public EmptyMessageException(String message) {
        super(message);
    }
    public EmptyMessageException() {
        super();
    }
}
