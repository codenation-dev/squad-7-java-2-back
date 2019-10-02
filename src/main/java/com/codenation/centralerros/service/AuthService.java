package com.codenation.centralerros.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codenation.centralerros.exception.ResourceNotFoundException;
import com.codenation.centralerros.model.User;
import com.codenation.centralerros.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		
		Optional<User> userOptional = repository.findByEmail(email);
		if (!userOptional.isPresent()) {
			throw new ResourceNotFoundException("Email não encontrado");
		}
		User user = userOptional.get();
		
		String newPass = newPassword();
		user.setPassword(pe.encode(newPass));
		
		repository.save(user);
		emailService.sendNewPasswordEmail(user, newPass);
	}

	private String newPassword() {
		char[] vet = new char[10];
		for (int i=0; i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { // gera um digito
			return (char) (rand.nextInt(10) + 48);
		}
		else if (opt == 1) { // gera letra maiuscula
			return (char) (rand.nextInt(26) + 65);
		}
		else { // gera letra minuscula
			return (char) (rand.nextInt(26) + 97);
		}
	}
}
