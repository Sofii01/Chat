package com.app.chat.infrastructure.persistence.adapter;

import com.app.chat.domain.model.ChatRoom;
import com.app.chat.domain.model.Message;
import com.app.chat.domain.port.output.MessageRepository;
import com.app.chat.infrastructure.config.exceptions.EmptyMessageException;
import com.app.chat.infrastructure.dtos.MessageResponseDto;
import com.app.chat.infrastructure.persistence.entity.MessageJpaEntity;
import com.app.chat.infrastructure.persistence.mapper.MessageMapper;
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
    private final MessageMapper mapper;

    public MessageJpaAdapter(MessageJpaRepository messageJpaRepository, ChatRoomJpaRepository chatRoomJpaRepository, MessageMapper mapper) {
        this.messageJpaRepository = messageJpaRepository;
        this.chatRoomJpaRepository = chatRoomJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public MessageResponseDto save(Message message) {
        if (message.getContent() == null || message.getContent().trim().isEmpty()) {
            throw new EmptyMessageException("Content cannot be empty");
        }
        MessageJpaEntity messageJpaEntity = new MessageJpaEntity();
        messageJpaEntity.setId(UUID.randomUUID());
        messageJpaEntity.setContent(message.getContent());
        messageJpaEntity.setSender(message.getSender());
        messageJpaEntity.setTimestamp(LocalDateTime.now());
        messageJpaEntity.setChatRoom(chatRoomJpaRepository
                .findById(message.getChatRoomId())
                .orElseThrow());
        Message save = toDomain(messageJpaRepository.save(messageJpaEntity));
        return mapper.toDto(save);
    }

    @Override
    public List<MessageResponseDto> findByChatRoomId(Long chatRoomId) {
        if (chatRoomId == null) {
            throw new IllegalArgumentException("Chat room id cannot be null");
        }
        return messageJpaRepository.findAll().stream()
                .filter(message -> message.getChatRoom() != null && message.getChatRoom().getId().equals(chatRoomId) )
                .map((entity)-> {
                    Message message = toDomain(entity);
                    return mapper.toDto(message);
                })
                .collect(Collectors.toList());
    }


    //este metodo puede realizarlo el mapstruct, pero lo especifique aca
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
