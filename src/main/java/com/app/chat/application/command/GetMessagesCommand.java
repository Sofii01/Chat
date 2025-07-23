package com.app.chat.application.command;

public class GetMessagesCommand {
    private Long chatRoomId;

    public GetMessagesCommand(Long chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public Long getChatRoomId() {
        return chatRoomId;
    }
}
