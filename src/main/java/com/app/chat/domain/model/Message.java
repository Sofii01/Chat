package com.app.chat.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Message {
    private final UUID id;
    private final String sender;
    private final String content;
    private final LocalDateTime timestamp;
    private final Long chatRoomId;

    public Message(UUID id, String sender, String content, LocalDateTime timestamp, Long chatRoomId) {
        if(sender == null || sender.isBlank()) throw new IllegalArgumentException("Sender is required");
        if(content == null || content.isBlank()) throw new IllegalArgumentException("Content is required");
        this.id = id != null ? id : UUID.randomUUID();
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp != null ? timestamp : LocalDateTime.now();
        this.chatRoomId = chatRoomId;
    }
    // Metodo de logica simple
    public static Message create(Long chatRoomId, String sender, String content) {
        if (chatRoomId == null) {
            throw new IllegalArgumentException("ChatRoom ID cannot be null");
        }
        if (sender == null || sender.trim().isEmpty()) {
            throw new IllegalArgumentException("Sender cannot be empty");
        }
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Content cannot be empty");
        }

        return new Message(
                UUID.randomUUID(),
                sender.trim(),
                content.trim(),
                LocalDateTime.now(),
                chatRoomId
        );
    }

    //Getters
    public UUID getId() {
        return id;
    }
    public String getSender() {
        return sender;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public String getContent() {
        return content;
    }

    public Long getChatRoomId() {
        return chatRoomId;
    }
}
