package com.app.chat.infrastructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class MessageResponseDto {
    private UUID id;
    private String sender;
    private String content;
    private LocalDateTime timestamp;
    private Long chatRoomId;
}
