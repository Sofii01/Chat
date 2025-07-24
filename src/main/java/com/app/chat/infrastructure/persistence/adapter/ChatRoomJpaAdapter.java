package com.app.chat.infrastructure.persistence.adapter;

import com.app.chat.domain.model.ChatRoom;
import com.app.chat.domain.port.output.ChatRoomRepository;
import com.app.chat.infrastructure.config.exceptions.ChatRoomNotFoundException;
import com.app.chat.infrastructure.dtos.ChatRoomResponseDto;
import com.app.chat.infrastructure.persistence.entity.ChatRoomJpaEntity;
import com.app.chat.infrastructure.persistence.mapper.ChatRoomMapper;
import com.app.chat.infrastructure.persistence.repository.ChatRoomJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ChatRoomJpaAdapter implements ChatRoomRepository {

    private final ChatRoomJpaRepository jpaRepository;
    private final ChatRoomMapper mapper;

    public ChatRoomJpaAdapter(ChatRoomJpaRepository jpaRepository, ChatRoomMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatRoomResponseDto save(String chatRoom) {
        ChatRoomJpaEntity chatRoomJpaEntity = new ChatRoomJpaEntity();
        chatRoomJpaEntity.setName(chatRoom);
        ChatRoom save = toDomain(jpaRepository.save(chatRoomJpaEntity));
        return mapper.toDto(save);
    }

    @Override
    public List<ChatRoomResponseDto> getAll() {
        return jpaRepository.findAll().stream()
                .map(entity -> {
                    ChatRoom chat = toDomain(entity);
                    return mapper.toDto(chat);
                })
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ChatRoomResponseDto> getById(Long id) {

        return Optional.of(jpaRepository.findById(id).map((entity) -> {
            ChatRoom chat = toDomain(entity);
            return mapper.toDto(chat);
        }).orElseThrow(()-> new ChatRoomNotFoundException("Chat room not found with id: " + id)));
    }

    public ChatRoom toDomain(ChatRoomJpaEntity chatRoomJpa){
        return new ChatRoom(chatRoomJpa.getId(), chatRoomJpa.getName());
    }
}
