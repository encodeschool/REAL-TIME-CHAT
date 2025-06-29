package com.example.simple_chat.chat.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatNotification {

    private Long id;
    private String senderId;
    private String recipientId;
    private String content;

}
