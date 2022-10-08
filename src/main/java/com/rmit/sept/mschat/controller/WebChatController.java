package com.rmit.sept.mschat.controller;

import com.rmit.sept.mschat.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebChatController {

    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message") // app destination: "/app/message"
    @SendTo("/chatroom/public")
    public ChatMessage receivePublicMessage (@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/private-message") // app destination: "/app/message"
    public ChatMessage receivePrivateMessage (@Payload ChatMessage chatMessage) {

        // endpoint: "/users/receiverName/private"
        simpMessagingTemplate.convertAndSendToUser(chatMessage.getReceiverName(), "/private", chatMessage);
        return chatMessage;
    }
}