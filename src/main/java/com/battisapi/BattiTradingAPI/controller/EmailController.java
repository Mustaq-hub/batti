package com.battisapi.BattiTradingAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.battisapi.BattiTradingAPI.entity.EmailDetails;
import com.battisapi.BattiTradingAPI.repository.EmailService;

@RestController
@CrossOrigin(exposedHeaders = {"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"})
public class EmailController {
	@Autowired 
	private EmailService emailService;
	
	@PostMapping("/sendMail")
    public String    sendMail(@RequestBody EmailDetails details)
    {
        String status
            = emailService.sendSimpleMail(details);
 
        return status;
    }

}
