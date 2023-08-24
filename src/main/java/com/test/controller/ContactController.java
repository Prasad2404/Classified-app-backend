package com.test.controller;


	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.*;

import com.test.model.Contact;
import com.test.service.ContactService;

import java.util.List;

	@Controller
	@RequestMapping("/contacts")
	public class ContactController {
	    @Autowired
	    private ContactService contactService;

	    @GetMapping("/")
	    public String listContacts(Model model) {
	        List<Contact> contacts = contactService.getAllContacts();
	        model.addAttribute("contacts", contacts);
	        return "contact/list";
	    }

	    @GetMapping("/add")
	    public String showAddContactForm(Model model) {
	        model.addAttribute("contact", new Contact());
	        return "contact/form";
	    }

	    @PostMapping("/add")
	    public String saveContact(@ModelAttribute Contact contact) {
	        contactService.saveContact(contact);
	        return "redirect:/contacts/";
	    }

	    @GetMapping("/edit/{id}")
	    public String showEditContactForm(@PathVariable Long id, Model model) {
	        Contact contact = contactService.getContactById(id);
	        model.addAttribute("contact", contact);
	        return "contact/form";
	    }

	    @PostMapping("/edit")
	    public String updateContact(@ModelAttribute Contact contact) {
	        contactService.saveContact(contact);
	        return "redirect:/contacts/";
	    }

	    @GetMapping("/delete/{id}")
	    public String deleteContact(@PathVariable Long id) {
	        contactService.deleteContact(id);
	        return "redirect:/contacts/";
	    }
	}



