package com.app.chat.domain.port.input;

import com.app.chat.domain.model.Message;
import com.app.chat.infrastructure.dtos.MessageResponseDto;

import java.util.List;

public interface GetMessagesUseCase {
    List<MessageResponseDto> getMessages(Long chatRoomId);
}
