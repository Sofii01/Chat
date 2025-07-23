package com.app.chat.application.service;

import com.app.chat.domain.model.ChatRoom;
import com.app.chat.domain.port.input.CreateChatRoomUseCase;
import com.app.chat.domain.port.input.GetAllChatRoomsUseCase;
import com.app.chat.domain.port.input.GetChatRoomByIdUseCase;
import com.app.chat.domain.port.output.ChatRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatRoomUseCaseImpl implements CreateChatRoomUseCase, GetAllChatRoomsUseCase, GetChatRoomByIdUseCase {

    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomUseCaseImpl(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }


    @Override
    public ChatRoom createChatRoom(String chatRoom) {
        return chatRoomRepository.save(chatRoom);
    }

    @Override
    public List<ChatRoom> getAll() {
        return chatRoomRepository.getAll();
    }

    @Override
    public Optional<ChatRoom> getById(Long id) {
        Optional<ChatRoom> chatRoom = chatRoomRepository.getById(id);
        return chatRoom;
    }
}
