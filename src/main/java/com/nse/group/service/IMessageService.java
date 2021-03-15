package com.nse.group.service;

import com.nse.group.entity.Message;

import java.util.List;

public interface IMessageService {

    Message saveMessage(Message message);

    List<Message> findMessages(int fromUser, int toUser);
}
