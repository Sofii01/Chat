package com.app.chat.domain.port.output;

import com.app.chat.domain.model.ChatRoom;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChatRoomRepository {
    ChatRoom save(ChatRoom chatRoom);
    List<ChatRoom> findAll();
    Optional<ChatRoom> findById(UUID id);
}
