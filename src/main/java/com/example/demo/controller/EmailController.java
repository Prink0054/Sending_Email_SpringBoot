package com.example.demo.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmailRequest;
import com.example.demo.service.EmailService;

//Java

@RestController
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@GetMapping("/welcome")
	public String welcome() {
		
		return "hello this is email api";
	}

	//api to send email
	@RequestMapping(value = "/sendEmail" ,method = RequestMethod.POST)
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request) throws MessagingException{
	
		
		
		System.out.println(request.getMessage());
		System.out.println(request.getSubject());
		System.out.println(request.getTo());

	boolean result= 	this.emailService.sendEmail(request.getSubject(),request.getMessage(),request.getTo());
		
	if(result) {
		return ResponseEntity.ok("email sent succesfully");

	}
	else {
		return ResponseEntity.ok("nOT SEND");
	}
	

	}

}
