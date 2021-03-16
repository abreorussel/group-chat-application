package com.nse.group.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nse.group.entity.Message;
import com.nse.group.repository.MessageRepository;

@Service
public class MessageService implements IMessageService{

	@Autowired
    MessageRepository repo;

	public Message saveMessage(Message message) {
		message.setSentAt(LocalDateTime.now());
		return repo.save(message);
	}

	public List<Message> findMessages(int fromUser, int toUser) {
		return repo.findByFromAndToUser(fromUser, toUser);
	}

}
