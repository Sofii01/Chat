package com.app.chat.infrastructure.rest;

import com.app.chat.application.command.SendMessageCommand;
import com.app.chat.application.handler.SendMessageHandler;
import com.app.chat.infrastructure.dtos.MessageResponseDto;
import com.app.chat.infrastructure.dtos.WebSocketMessageRequest;
import com.app.chat.infrastructure.dtos.WebSocketMessageResponse;
import com.app.chat.infrastructure.persistence.mapper.WebSocketMapper;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatWebSocketController {
    private final SendMessageHandler sendMessageHandler;
    private final WebSocketMapper mapper;
    private final SimpMessagingTemplate messagingTemplate;

    public ChatWebSocketController(SendMessageHandler sendMessageHandler, WebSocketMapper mapper, SimpMessagingTemplate messagingTemplate) {
        this.sendMessageHandler = sendMessageHandler;
        this.mapper = mapper;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat/send") // Escucha mensajes enviados a /app/chat/send
    public void sendMessage(WebSocketMessageRequest message) {
        SendMessageCommand command = new SendMessageCommand(
                message.getChatRoomId(), message.getSender(), message.getContent()
        );

        MessageResponseDto messageDto = sendMessageHandler.handle(command);
        WebSocketMessageResponse webSocketMessage =  mapper.toResponse(messageDto);

        // Publica el mensaje a todos los que estén suscritos a este topic
        messagingTemplate.convertAndSend("/topic/messages", webSocketMessage);
    }
}
