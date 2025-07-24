package com.app.chat.domain.port.output;

import com.app.chat.domain.model.Message;
import com.app.chat.infrastructure.dtos.MessageResponseDto;

import java.util.List;


public interface MessageRepository {
    MessageResponseDto save(Message message);
    List<MessageResponseDto> findByChatRoomId(Long chatRoomId);
}
