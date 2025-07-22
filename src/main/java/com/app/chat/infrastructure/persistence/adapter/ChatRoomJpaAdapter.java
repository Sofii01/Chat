package com.app.chat.infrastructure.persistence.adapter;

import com.app.chat.domain.model.ChatRoom;
import com.app.chat.domain.port.output.ChatRoomRepository;
import com.app.chat.infrastructure.persistence.entity.ChatRoomJpaEntity;
import com.app.chat.infrastructure.persistence.repository.ChatRoomJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ChatRoomJpaAdapter implements ChatRoomRepository {

    private final ChatRoomJpaRepository jpaRepository;

    public ChatRoomJpaAdapter(ChatRoomJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ChatRoom save(String chatRoom) {
        ChatRoomJpaEntity chatRoomJpaEntity = new ChatRoomJpaEntity();
        chatRoomJpaEntity.setName(chatRoom);
        return toDomain(jpaRepository.save(chatRoomJpaEntity));
    }

    @Override
    public List<ChatRoom> getAll() {
        return jpaRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<ChatRoom> getById(Long id) {

        return jpaRepository.findById(id).map(this::toDomain);
    }

    public ChatRoom toDomain(ChatRoomJpaEntity chatRoomJpa){
        return new ChatRoom(chatRoomJpa.getId(), chatRoomJpa.getName());
    }
}
