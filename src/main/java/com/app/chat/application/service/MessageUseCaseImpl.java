package com.app.chat.application.service;

import com.app.chat.domain.model.Message;
import com.app.chat.domain.port.input.GetMessagesUseCase;
import com.app.chat.domain.port.input.SendMessageUseCase;
import com.app.chat.domain.port.output.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageUseCaseImpl implements SendMessageUseCase, GetMessagesUseCase {
    private final MessageRepository messageRepository;

    public MessageUseCaseImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message sendMessage(Message message) {
        if(message.getContent() == null || message.getContent().trim().isEmpty()) {
            throw new IllegalArgumentException("Message content cannot be empty");
        }
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getMessages(Long chatRoomId) {
        return messageRepository.findByChatRoomId(chatRoomId);
    }
}
