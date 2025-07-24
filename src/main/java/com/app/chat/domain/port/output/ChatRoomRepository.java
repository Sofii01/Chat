package com.app.chat.domain.port.output;

import com.app.chat.domain.model.ChatRoom;
import com.app.chat.infrastructure.dtos.ChatRoomResponseDto;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository {
    ChatRoomResponseDto save(String name);
    List<ChatRoomResponseDto> getAll();
    Optional<ChatRoomResponseDto> getById(Long id);
}
