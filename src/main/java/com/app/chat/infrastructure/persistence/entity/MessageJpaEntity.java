package com.app.chat.infrastructure.persistence.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "messages")
public class MessageJpaEntity {
    @Id
    private UUID id;
    private String sender;
    private String content;

    private LocalDateTime timestamp;
    @ManyToOne
    @JoinColumn(name = "chat_room_id")
    private ChatRoomJpaEntity chatRoomId;

}
