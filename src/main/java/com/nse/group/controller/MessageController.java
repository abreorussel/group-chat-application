package com.nse.group.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nse.group.controller.MessageController;
import com.nse.group.entity.Message;
import com.nse.group.service.MessageService;

@RestController
@RequestMapping("/api")
public class MessageController {
	@Autowired
	MessageService service;

	@PostMapping(value = "/save-message", consumes = "application/json")
	public Message saveMessage(@RequestBody Message message) {

		return service.saveMessage(message);

	}

	@GetMapping("/getMessages/{fromUser}/{toUser}")
	public List<Message> findMessageById(@PathVariable int fromUser, @PathVariable int toUser) {
		return service.findMessages(fromUser, toUser);
	}

}
