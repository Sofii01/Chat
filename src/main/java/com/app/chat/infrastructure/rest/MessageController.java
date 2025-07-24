package com.app.chat.infrastructure.rest;

import com.app.chat.application.command.GetMessagesCommand;
import com.app.chat.application.command.SendMessageCommand;
import com.app.chat.application.handler.GetMessagesHandler;
import com.app.chat.application.handler.SendMessageHandler;
import com.app.chat.domain.model.Message;
import com.app.chat.infrastructure.dtos.MessageResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@Tag(name = "Mensajes", description = "Operaciones relacionadas con los mensajes")
public class MessageController {
    private final SendMessageHandler sendMessageHandler;
    private final GetMessagesHandler getMessagesHandler;

    public MessageController(SendMessageHandler sendMessageHandler, GetMessagesHandler getMessagesHandler) {
        this.sendMessageHandler = sendMessageHandler;
        this.getMessagesHandler = getMessagesHandler;
    }

    @PostMapping("/send")
    @Operation(summary = "Envia un mensaje", description = "Realiza el envio de un mensaje y lo guarda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mensaje enviado con exito ")
    })
    public ResponseEntity<MessageResponseDto> sendMessage(@Valid @RequestBody SendMessageCommand command) {
        MessageResponseDto message = sendMessageHandler.handle(command);
        return ResponseEntity.ok(message);
    }

    @Operation(summary = "Obtener todos los mensajes de una sala ", description = "Devuelve una lista de mensajes de una sala de chat dada")
    @GetMapping("/messages")
    public ResponseEntity<List<MessageResponseDto>> getMessages(
            @Parameter(description = "ID de la sala de chat") @RequestParam Long chatRoomId) {
        if (chatRoomId == null) {
            throw new IllegalArgumentException("Chat room id cannot be null");
        }
        GetMessagesCommand command = new GetMessagesCommand(chatRoomId);
        List<MessageResponseDto> messages = getMessagesHandler.handle(command);
        return ResponseEntity.ok(messages);
    }
}
