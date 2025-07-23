package com.app.chat.infrastructure.persistence.adapter;

import com.app.chat.domain.model.Message;
import com.app.chat.domain.port.output.MessageRepository;
import com.app.chat.infrastructure.persistence.entity.MessageJpaEntity;
import com.app.chat.infrastructure.persistence.repository.ChatRoomJpaRepository;
import com.app.chat.infrastructure.persistence.repository.MessageJpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class MessageJpaAdapter implements MessageRepository {
    private final MessageJpaRepository messageJpaRepository;
    private final ChatRoomJpaRepository chatRoomJpaRepository;

    public MessageJpaAdapter(MessageJpaRepository messageJpaRepository, ChatRoomJpaRepository chatRoomJpaRepository) {
        this.messageJpaRepository = messageJpaRepository;
        this.chatRoomJpaRepository = chatRoomJpaRepository;
    }

    @Override
    public Message save(Message message) {
        MessageJpaEntity messageJpaEntity = new MessageJpaEntity();
        messageJpaEntity.setId(UUID.randomUUID());
        messageJpaEntity.setContent(message.getContent());
        messageJpaEntity.setSender(message.getSender());
        messageJpaEntity.setTimestamp(LocalDateTime.now());
        messageJpaEntity.setChatRoom(chatRoomJpaRepository
                .findById(message.getChatRoomId())
                .orElseThrow());
        return toDomain(messageJpaRepository.save(messageJpaEntity));
    }

    @Override
    public List<Message> findByChatRoomId(Long chatRoomId) {
        if (chatRoomId == null) {
            throw new IllegalArgumentException("Chat room id cannot be null");
        }
        return messageJpaRepository.findAll().stream()
                .filter(message -> message.getChatRoom() != null && message.getChatRoom().getId().equals(chatRoomId) )
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public Message toDomain(MessageJpaEntity entity){
        Long chatRoomId = entity.getChatRoom() != null ? entity.getChatRoom().getId() : null;
        return new Message(
                entity.getId(),
                entity.getSender(),
                entity.getContent(),
                entity.getTimestamp(),
                chatRoomId);
    }

}
