package com.app.chat.application.handler;

import com.app.chat.application.command.GetMessagesCommand;
import com.app.chat.domain.model.Message;
import com.app.chat.domain.port.input.GetMessagesUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetMessagesHandler {
    private final GetMessagesUseCase getMessagesUseCase;

    public GetMessagesHandler(GetMessagesUseCase getMessagesUseCase) {
        this.getMessagesUseCase = getMessagesUseCase;
    }
    public List<Message> handle(GetMessagesCommand command) {
        return getMessagesUseCase.getMessages(command.getChatRoomId());
    }
}
