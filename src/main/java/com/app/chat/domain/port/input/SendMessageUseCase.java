package com.app.chat.domain.port.input;

import com.app.chat.domain.model.Message;
import com.app.chat.infrastructure.dtos.MessageResponseDto;

public interface SendMessageUseCase {
    MessageResponseDto sendMessage(Message message);
}
