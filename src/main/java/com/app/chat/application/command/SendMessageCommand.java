package com.app.chat.application.command;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SendMessageCommand {
    @NotBlank
    @Min(1)
    private Long chatRoomId;
    @NotBlank
    @Size(min = 1, max = 255)
    private String sender;
    @NotBlank
    @Size(min = 1, max = 255)
    private String content;

    public SendMessageCommand(Long chatRoomId, String sender, String content) {
        this.chatRoomId = chatRoomId;
        this.sender = sender;
        this.content = content;
    }

    public Long getChatRoomId() {
        return chatRoomId;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }
}
