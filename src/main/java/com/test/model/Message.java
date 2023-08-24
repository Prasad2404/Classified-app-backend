package com.test.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
	
		

		@Entity
		@Data
		@NoArgsConstructor
		public class Message {
		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;

		    @ManyToOne
		    @JoinColumn(name = "sender_id")
		    private User sender;

		    @ManyToOne
		    @JoinColumn(name = "receiver_id")
		    private User receiver;

		    private String content;
		    private LocalDateTime timestamp;
		}




