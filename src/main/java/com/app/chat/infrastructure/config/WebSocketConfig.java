package com.app.chat.infrastructure.config;

import com.app.chat.infrastructure.config.exceptions.ErrorResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    //para verificar el funcionamiento correcto debo utilizar un cliente que necesita hablar con el protocolo SockJS + STOMP.
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Mensajes enviados a los suscriptores
        config.enableSimpleBroker("/topic"); // broker interno para enviar
        config.setApplicationDestinationPrefixes("/app"); // cliente envía aquí
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Endpoint al que se conectan los clientes (con SockJS como fallback)
        registry.addEndpoint("/ws-chat").setAllowedOriginPatterns("*").withSockJS();
    }
    @MessageExceptionHandler
    @SendTo("/topic/errors")
    public ErrorResponse handleWebSocketException(Exception ex) {
        return ErrorResponse.builder()
                .status(400)
                .error("WebSocket Error")
                .message(ex.getMessage())
                .path("/ws/chat")
                .build();
    }
}
