package com.app.chat.application.command;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class GetMessagesCommand {
    @NotNull
    @Min(1)
    private Long chatRoomId;

    public GetMessagesCommand(Long chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public Long getChatRoomId() {
        return chatRoomId;
    }
}
