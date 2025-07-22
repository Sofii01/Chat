package com.app.chat.infrastructure.rest;


import com.app.chat.application.service.ChatRoomServiceImpl;
import com.app.chat.domain.model.ChatRoom;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chatrooms")
public class ChatRoomController {
    private final ChatRoomServiceImpl service;

    public ChatRoomController(ChatRoomServiceImpl service) {
        this.service = service;
    }
    @PostMapping
    public ChatRoom save(@RequestParam String chatRoom) {
        ChatRoom chat = service.createChatRoom(chatRoom);
        return chat;
    }
    @GetMapping
    public ResponseEntity<List<ChatRoom>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatRoom> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
