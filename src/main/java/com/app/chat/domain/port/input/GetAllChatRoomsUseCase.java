package com.app.chat.domain.port.input;

import com.app.chat.domain.model.ChatRoom;
import com.app.chat.infrastructure.dtos.ChatRoomResponseDto;

import java.util.List;

public interface GetAllChatRoomsUseCase {
    List<ChatRoomResponseDto> getAll();
}
