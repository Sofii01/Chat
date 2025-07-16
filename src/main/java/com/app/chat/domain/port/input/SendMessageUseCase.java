package com.app.chat.domain.port.input;

import com.app.chat.domain.model.Message;

public interface SendMessageUseCase {
    Message sendMessage(Message message);
}
