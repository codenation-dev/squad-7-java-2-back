package com.codenation.centralerros.service;

import org.springframework.mail.SimpleMailMessage;

import com.codenation.centralerros.model.User;


public interface EmailService {
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(User user, String newPass);
}
