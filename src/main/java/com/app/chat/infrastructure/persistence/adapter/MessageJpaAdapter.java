package com.app.chat.infrastructure.persistence.adapter;

import com.app.chat.domain.model.Message;
import com.app.chat.domain.port.output.MessageRepository;

import java.util.List;
import java.util.UUID;

public class MessageJpaAdapter implements MessageRepository {
    @Override
    public Message save(Message message) {
        return null;
    }

    @Override
    public List<Message> findByChatRoomId(UUID chatRoomId) {
        return List.of();
    }
}
