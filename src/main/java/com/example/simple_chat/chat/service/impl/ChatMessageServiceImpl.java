package com.example.simple_chat.chat.service.impl;

import com.example.simple_chat.chat.entity.ChatMessage;
import com.example.simple_chat.chat.repository.ChatMessageRepository;
import com.example.simple_chat.chat.service.ChatMessageService;
import com.example.simple_chat.chatRoom.repository.ChatRoomRepository;
import com.example.simple_chat.chatRoom.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private ChatRoomService chatRoomService;


    @Override
    public ChatMessage saveChatMessage(ChatMessage chatMessage) {
        var chatId = chatRoomService.getChatRoomId(
                chatMessage.getSenderId(),
                chatMessage.getRecipientId(),
                true
        ).orElseThrow(); // YOu can create your own dedicated exception
        chatMessage.setChatId(chatId);
        chatMessageRepository.save(chatMessage);
        return chatMessage;
    }

    @Override
    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        var chatId = chatRoomService.getChatRoomId(senderId, recipientId, false);
        return chatId.map(chatMessageRepository::findByChatId).orElse(new ArrayList<>());
    }
}
