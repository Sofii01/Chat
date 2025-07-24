package com.app.chat.infrastructure.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ChatRoomResponseDto {
    private Long id;
    private String name;
}
