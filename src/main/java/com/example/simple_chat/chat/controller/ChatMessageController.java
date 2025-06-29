package com.example.simple_chat.chat.controller;

import com.example.simple_chat.chat.entity.ChatMessage;
import com.example.simple_chat.chat.entity.ChatNotification;
import com.example.simple_chat.chat.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ChatMessageController {

    @Autowired
    private ChatMessageService chatMessageService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage chatMessage){
        ChatMessage savedMessage = chatMessageService.saveChatMessage(chatMessage);
        simpMessagingTemplate.convertAndSendToUser(chatMessage.getRecipientId(), "/queue/messages",
                new ChatNotification(
                    savedMessage.getId(),
                    savedMessage.getSenderId(),
                    savedMessage.getRecipientId(),
                    savedMessage.getContent()
                )
        );
    }

    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<ChatMessage>> findChatMessages(@PathVariable String senderId, @PathVariable String recipientId) {
        return ResponseEntity.ok(chatMessageService.findChatMessages(senderId, recipientId));
    }

}
