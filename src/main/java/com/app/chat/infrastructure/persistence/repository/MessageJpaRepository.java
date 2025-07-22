package com.app.chat.infrastructure.persistence.repository;

import com.app.chat.infrastructure.persistence.entity.MessageJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageJpaRepository extends JpaRepository<MessageJpaEntity, UUID> {
}
