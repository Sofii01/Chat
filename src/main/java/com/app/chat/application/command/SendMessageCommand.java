package com.app.chat.application.command;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class SendMessageCommand {
    @NotNull
    @Min(1)
    private Long chatRoomId;
    @NotBlank
    @Size(min = 1, max = 100)
    private String sender;
    @NotBlank @Size(min = 1, max = 255)
    private String content;

    public SendMessageCommand(Long chatRoomId, String sender, String content) {
        this.chatRoomId = chatRoomId;
        this.sender = sender;
        this.content = content;
    }

}
