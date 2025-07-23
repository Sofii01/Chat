package com.app.chat.application.handler;

import com.app.chat.application.command.SendMessageCommand;
import com.app.chat.domain.model.Message;
import com.app.chat.domain.port.input.SendMessageUseCase;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SendMessageHandler {
    private final SendMessageUseCase sendMessageUseCase;

    public SendMessageHandler(SendMessageUseCase sendMessageUseCase) {
        this.sendMessageUseCase = sendMessageUseCase;
    }
    public Message handle(SendMessageCommand command) {
        // validar datos antes

        Message message = Message.create(
                command.getChatRoomId(),
                command.getSender(),
                command.getContent()
        );

        return sendMessageUseCase.sendMessage(message);
    }
}
