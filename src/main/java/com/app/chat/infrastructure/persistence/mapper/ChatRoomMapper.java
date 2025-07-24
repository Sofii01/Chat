package com.app.chat.infrastructure.persistence.mapper;

import com.app.chat.domain.model.ChatRoom;
import com.app.chat.infrastructure.dtos.ChatRoomResponseDto;
import com.app.chat.infrastructure.persistence.entity.ChatRoomJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChatRoomMapper {
    ChatRoomResponseDto toDto(ChatRoom chatRoom);
}
