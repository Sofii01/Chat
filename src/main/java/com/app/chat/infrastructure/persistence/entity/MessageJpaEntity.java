package com.app.chat.infrastructure.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "messages")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class MessageJpaEntity {
    @Id
    private UUID id;
    private String sender;
    private String content;

    private LocalDateTime timestamp;
    @ManyToOne
    @JoinColumn(name = "chat_room_id")
    private ChatRoomJpaEntity chatRoom;

}
