package com.test.service.impl;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.test.model.Contact;
import com.test.repository.ContactRepository;
import com.test.service.ContactService;

import java.util.List;

	@Service
	public class ContactServiceImpl implements ContactService {
	    @Autowired
	    private ContactRepository contactRepository;

	    @Override
	    public List<Contact> getAllContacts() {
	        return contactRepository.findAll();
	    }

	    @Override
	    public Contact getContactById(Long id) {
	        return contactRepository.findById(id).orElse(null);
	    }

	    @Override
	    public void saveContact(Contact contact) {
	        contactRepository.save(contact);
	    }

	    @Override
	    public void deleteContact(Long id) {
	        contactRepository.deleteById(id);
	    }
	}


