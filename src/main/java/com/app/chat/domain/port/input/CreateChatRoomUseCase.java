package com.app.chat.domain.port.input;

import com.app.chat.domain.model.ChatRoom;
import com.app.chat.infrastructure.dtos.ChatRoomResponseDto;

public interface CreateChatRoomUseCase {
    ChatRoomResponseDto createChatRoom(String chatRoom);
}
