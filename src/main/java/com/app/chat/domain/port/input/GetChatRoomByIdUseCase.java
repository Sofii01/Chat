package com.app.chat.domain.port.input;

import com.app.chat.domain.model.ChatRoom;
import com.app.chat.infrastructure.dtos.ChatRoomResponseDto;

import java.util.Optional;

public interface GetChatRoomByIdUseCase {
    Optional<ChatRoomResponseDto> getById(Long id);
}
