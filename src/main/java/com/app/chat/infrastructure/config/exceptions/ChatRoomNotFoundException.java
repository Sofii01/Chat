package com.app.chat.infrastructure.config.exceptions;

public class ChatRoomNotFoundException extends RuntimeException {
    public ChatRoomNotFoundException(String message) {
        super(message);
    }

}
