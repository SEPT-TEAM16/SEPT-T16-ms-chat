package com.rmit.sept.mschat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {

    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private Status status;
}
