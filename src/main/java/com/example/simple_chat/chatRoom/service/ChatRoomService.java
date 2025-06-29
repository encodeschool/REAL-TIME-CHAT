package com.example.simple_chat.chatRoom.service;

import com.example.simple_chat.chatRoom.entity.ChatRoom;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ChatRoomService {

    Optional<String> getChatRoomId(String senderId, String recipientId, boolean createNewRoomIfNotExists) ;

}
