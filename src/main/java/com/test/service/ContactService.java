package com.test.service;


	import java.util.List;

import com.test.model.Contact;

	public interface ContactService {
	    List<Contact> getAllContacts();
	    Contact getContactById(Long id);
	    void saveContact(Contact contact);
	    void deleteContact(Long id);
	}


