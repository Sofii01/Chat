package com.app.chat.domain.model;

import java.util.UUID;

public class ChatRoom {
    private final UUID id;
    private final String name;

    public ChatRoom(UUID id, String name) {
        if(name == null || name.isBlank()) throw new IllegalArgumentException("Name is required");
        this.id = id != null ? id : UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
