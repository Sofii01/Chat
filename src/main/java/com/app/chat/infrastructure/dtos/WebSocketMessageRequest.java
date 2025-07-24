package com.app.chat.infrastructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class WebSocketMessageRequest {
    private Long chatRoomId;
    private String sender;
    private String content;
}
