package com.app.chat.infrastructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class WebSocketMessageResponse {
    private UUID id;
    private Long chatRoomId;
    private String sender;
    private String content;
    private LocalDateTime timestamp;
}
