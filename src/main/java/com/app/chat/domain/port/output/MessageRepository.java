package com.app.chat.domain.port.output;

import com.app.chat.domain.model.Message;

import java.util.List;


public interface MessageRepository {
    Message save(Message message);
    List<Message> findByChatRoomId(Long chatRoomId);
}
