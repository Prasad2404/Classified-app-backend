package com.test.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Message;
import com.test.model.User;
import com.test.repository.MessageRepository;
import com.test.service.MessageService;

@Service
	public class MessageServiceImpl implements MessageService {
	    @Autowired
	    private MessageRepository messageRepository;

	    @Override
	    public List<Message> getMessagesBetweenUsers(User user1, User user2) {
	        return messageRepository.findBySenderAndReceiverOrderByTimestamp(user1, user2);
	    }

	    @Override
	    public void saveMessage(Message message) {
	        message.setTimestamp(LocalDateTime.now());
	        messageRepository.save(message);
	    }
	}


