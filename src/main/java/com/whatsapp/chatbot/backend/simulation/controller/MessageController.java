package com.whatsapp.chatbot.backend.simulation.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.whatsapp.chatbot.backend.simulation.model.MessageRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageController {
	
	@PostMapping("/webhook")
	public String receiveMessage(@RequestBody MessageRequest request) {
		
		
	    String msg = request.getMessage();
	    
	    log.info("Received message: {}", msg);

	    if ("Hi".equalsIgnoreCase(msg)) {
	        return "Hello";
	    } 
	    else if ("Bye".equalsIgnoreCase(msg)) {
	        return "Goodbye";
	    }

	    return "Unknown message";
	}
}
