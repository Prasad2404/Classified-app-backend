package com.test.service;

import java.util.List;

import com.test.model.Message;
import com.test.model.User;

public interface MessageService {
	    List<Message> getMessagesBetweenUsers(User user1, User user2);
	    void saveMessage(Message message);
	}


