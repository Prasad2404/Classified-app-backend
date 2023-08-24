package com.test.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Message;
import com.test.model.User;

	public interface MessageRepository extends JpaRepository<Message, Long> {
	    List<Message> findBySenderAndReceiverOrderByTimestamp(User sender, User receiver);
	}


