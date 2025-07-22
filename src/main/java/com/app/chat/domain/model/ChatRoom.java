package com.app.chat.domain.model;

import java.util.UUID;

public class ChatRoom {
    private final Long id;
    private final String name;

    public ChatRoom(Long id, String name) {
        if(name == null || name.isBlank()) throw new IllegalArgumentException("Name is required");
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
