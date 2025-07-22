package com.app.chat.domain.port.input;

import com.app.chat.domain.model.ChatRoom;

import java.util.List;

public interface GetAllChatRoomsUseCase {
    List<ChatRoom> getAll();
}
