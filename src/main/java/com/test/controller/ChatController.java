package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.model.Message;
import com.test.model.User;
import com.test.repository.UserRepository;
import com.test.service.MessageService;

@Controller
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private MessageService messageService;

    @Autowired
    private UserRepository userRepository;

    private User currentUser;

    @GetMapping("/{username}")
    public String showChat(@PathVariable String username, Model model) {
        User otherUser = userRepository.findByUsername(username);
        List<Message> messages = messageService.getMessagesBetweenUsers(currentUser, otherUser);
        
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("otherUser", otherUser);
        model.addAttribute("messages", messages);
        
        return "chat";
    }
    
    @PostMapping("/send")
    public String sendMessage(@RequestParam  String content, @RequestParam Long receiverId) {
        if (currentUser == null) {
            // Handle the case when currentUser is not set (not authenticated)
            return "redirect:/login"; // Redirect to login page or handle appropriately
        }
        
        User receiver = userRepository.findById(receiverId).orElse(null);
        
        if (receiver != null) {
            Message message = new Message();
            message.setSender(currentUser);
            message.setReceiver(receiver);
            message.setContent(content);
            messageService.saveMessage(message);
            
            
            return "redirect:/chat/" + receiver.getUsername();
        }
        
        // Handle case when receiver is null
        return "redirect:/"; // Redirect to a default page or handle appropriately
    }
    
    // A simple setter for the current user (you can call this from a login method)
    public void setCurrentUser(User user) {
        currentUser = user;
    }
}

	
	
		
		    
		

	    

