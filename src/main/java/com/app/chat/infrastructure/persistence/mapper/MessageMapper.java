package com.app.chat.infrastructure.persistence.mapper;


import com.app.chat.domain.model.Message;
import com.app.chat.infrastructure.dtos.MessageResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageResponseDto toDto(Message message);
}
