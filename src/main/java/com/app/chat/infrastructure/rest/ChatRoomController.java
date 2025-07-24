package com.app.chat.infrastructure.rest;


import com.app.chat.application.service.ChatRoomUseCaseImpl;
import com.app.chat.domain.model.ChatRoom;
import com.app.chat.infrastructure.dtos.ChatRoomRequestDto;
import com.app.chat.infrastructure.dtos.ChatRoomResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chatrooms")
@Tag(name = "Chat", description = "Operaciones relacionadas con el chat")
public class ChatRoomController {
    private final ChatRoomUseCaseImpl service;

    public ChatRoomController(ChatRoomUseCaseImpl service) {
        this.service = service;
    }


    @PostMapping
    @Operation(summary = "Crear sala de chat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sala creada exitosamente")
    })
    public ResponseEntity<ChatRoomResponseDto> save(@RequestBody ChatRoomRequestDto requestDto) {
        ChatRoomResponseDto chat = service.createChatRoom(requestDto.getName());
        return new ResponseEntity <>(chat, HttpStatus.CREATED);
    }
    @GetMapping
    @Operation(summary = "Obtener un listado de todas las salas")
    public ResponseEntity<List<ChatRoomResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una sala por el ID")
    public ResponseEntity<ChatRoomResponseDto> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
