package com.app.chat.application.command;

public class SendMessageCommand {
    private Long chatRoomId;
    private String sender;
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
