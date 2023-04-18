package com.battisapi.BattiTradingAPI.repository;

import com.battisapi.BattiTradingAPI.entity.EmailDetails;

public interface EmailService {
	
	 String sendSimpleMail(EmailDetails details);

}
