
package com.codenation.centralerros.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codenation.centralerros.controller.advice.ResourceNotFoundException;
import com.codenation.centralerros.model.User;
import com.codenation.centralerros.repository.UserRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public ResponseEntity<User> findByUserId(@PathVariable("id") Long id) {
		return new ResponseEntity<User>(userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User")), HttpStatus.OK);
	}
	
	@GetMapping
    @ApiOperation("Lista todos os usuários")
    public Iterable<User> findAll(@PathParam("nome") String nome, Pageable pageable) {
        if (nome != null) {
            return this.userRepository.findByName(nome.toString(), pageable);
        }
        return this.userRepository.findAll(pageable);
    }
	
	@PostMapping
    @ApiOperation("Cria um novo usuário")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Usuário criado com sucesso")})
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        return new ResponseEntity<User>(this.userRepository.save(user), HttpStatus.CREATED);
    }

}