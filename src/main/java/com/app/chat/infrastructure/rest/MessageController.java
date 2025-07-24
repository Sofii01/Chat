package com.app.chat.infrastructure.rest;

import com.app.chat.application.command.GetMessagesCommand;
import com.app.chat.application.command.SendMessageCommand;
import com.app.chat.application.handler.GetMessagesHandler;
import com.app.chat.application.handler.SendMessageHandler;
import com.app.chat.domain.model.Message;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class MessageController {
    private final SendMessageHandler sendMessageHandler;
    private final GetMessagesHandler getMessagesHandler;

    public MessageController(SendMessageHandler sendMessageHandler, GetMessagesHandler getMessagesHandler) {
        this.sendMessageHandler = sendMessageHandler;
        this.getMessagesHandler = getMessagesHandler;
    }
    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@Valid @RequestBody SendMessageCommand command) {
        Message message = sendMessageHandler.handle(command);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getMessages(@RequestParam Long chatRoomId) {
        if (chatRoomId == null) {
            throw new IllegalArgumentException("Chat room id cannot be null");
        }
        GetMessagesCommand command = new GetMessagesCommand(chatRoomId);
        List<Message> messages = getMessagesHandler.handle(command);
        return ResponseEntity.ok(messages);
    }
}
