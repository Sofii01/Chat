package com.app.chat.infrastructure.persistence.repository;

import com.app.chat.infrastructure.persistence.entity.ChatRoomJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChatRoomJpaRepository extends JpaRepository<ChatRoomJpaEntity, Long> {
}
