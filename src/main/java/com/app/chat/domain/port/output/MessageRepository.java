package com.app.chat.domain.port.output;

import com.app.chat.domain.model.Message;

import java.util.List;
import java.util.UUID;

public interface MessageRepository {
    Message save(Message message);
    List<Message> findByChatRoomId(UUID chatRoomId);
}
