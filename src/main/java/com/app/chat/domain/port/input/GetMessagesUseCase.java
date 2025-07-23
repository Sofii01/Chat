package com.app.chat.domain.port.input;

import com.app.chat.domain.model.Message;

import java.util.List;

public interface GetMessagesUseCase {
    List<Message> getMessages(Long chatRoomId);
}
