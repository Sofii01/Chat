package com.app.chat.domain.port.input;

import com.app.chat.domain.model.ChatRoom;

public interface CreateChatRoomUseCase {
    ChatRoom createChatRoom(String chatRoom);
}
