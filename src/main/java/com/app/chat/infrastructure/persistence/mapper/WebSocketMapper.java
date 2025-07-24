package com.app.chat.infrastructure.persistence.mapper;

import com.app.chat.infrastructure.dtos.MessageResponseDto;
import com.app.chat.infrastructure.dtos.WebSocketMessageRequest;
import com.app.chat.infrastructure.dtos.WebSocketMessageResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WebSocketMapper {
    WebSocketMessageResponse toResponse(MessageResponseDto messageResponseDto);
}
