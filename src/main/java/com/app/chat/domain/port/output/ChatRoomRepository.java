package com.app.chat.domain.port.output;

import com.app.chat.domain.model.ChatRoom;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository {
    ChatRoom save(String name);
    List<ChatRoom> getAll();
    Optional<ChatRoom> getById(Long id);
}
