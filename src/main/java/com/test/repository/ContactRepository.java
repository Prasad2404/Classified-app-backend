package com.test.repository;


	import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Contact;

	public interface ContactRepository extends JpaRepository<Contact, Long> {
	}


