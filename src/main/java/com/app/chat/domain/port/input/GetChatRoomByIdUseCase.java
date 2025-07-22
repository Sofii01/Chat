package com.app.chat.domain.port.input;

import com.app.chat.domain.model.ChatRoom;

import java.util.Optional;

public interface GetChatRoomByIdUseCase {
    Optional<ChatRoom> getById(Long id);
}
