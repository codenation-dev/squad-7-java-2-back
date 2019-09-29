package com.codenation.centralerros.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.codenation.centralerros.exception.ResourceNotFoundException;
import com.codenation.centralerros.model.User;
import com.codenation.centralerros.repository.UserRepository;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@ControllerAdvice
@RestController
@EnableWebMvc
@RequestMapping("/user")

@AllArgsConstructor
@Api(value = "central de erros")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/{id}")
	public ResponseEntity<User> findByUserId(@PathVariable("id") Long id) {
		return new ResponseEntity<User>( userRepository.findById( id )
				.orElseThrow( () -> new ResourceNotFoundException( "User" ) ), HttpStatus.OK );
	}

	@GetMapping()
	public Iterable<User> findAll(@RequestParam(value = "nome", required = false) String nome, Pageable pageable) {
		if (nome != null) {
			return this.userRepository.findByName( nome.toString(), pageable );
		}
		return this.userRepository.findAll( pageable );
	}

	@PostMapping
	public ResponseEntity<User> create(@Valid @RequestBody User user) {
		return new ResponseEntity<User>( this.userRepository.save( user ), HttpStatus.CREATED );
	}

}