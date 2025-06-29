package com.example.simple_chat.chat.service;

import com.example.simple_chat.chat.entity.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatMessageService {

    ChatMessage saveChatMessage(ChatMessage chatMessage);

    List<ChatMessage> findChatMessages(String senderId, String recipientId);

}
