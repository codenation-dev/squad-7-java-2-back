package com.codenation.centralerros.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.codenation.centralerros.dto.LogErrorDTO;
import com.codenation.centralerros.dto.LogErrorPesquisaDTO;
import com.codenation.centralerros.dto.PageDTO;
import com.codenation.centralerros.model.enums.Environment;
import com.codenation.centralerros.service.LogErrorService;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@ControllerAdvice
@RestController
@EnableWebMvc
@RequestMapping("/log")
@AllArgsConstructor
@Api(value = "central de erros")
public class LogErrorController {

	@Autowired
	private LogErrorService logErrorService;

	@PostMapping
	public ResponseEntity<Object> save(@Valid @RequestBody LogErrorDTO logError) {
		LogErrorDTO log = logErrorService.save(logError);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(log.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping()
	public List<LogErrorDTO> findAll() {
		return logErrorService.findAll();
	}

	@GetMapping(value = "filter")
	public Page<LogErrorDTO> findAll(LogErrorPesquisaDTO dto, PageDTO page) {
		return logErrorService.pesquisaLogAvancada(dto, page);

	}

	@GetMapping("/{id}")
	public LogErrorDTO findById(@PathVariable("id") Long id) {
		return logErrorService.findById(id);
	}
	
	@PutMapping
	public LogErrorDTO update(@Valid @NotNull @RequestBody final LogErrorDTO logError) {
		return this.logErrorService.save(logError);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@NotNull @PathVariable("id") final Long id) {
		try {
			this.logErrorService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultDataAccessException("Registro não encontrado, ID:"+ id.toString(), 1);
		}
	}
	
	@GetMapping(value = "/environment")
	public List<LogErrorDTO> findByEnvironment(Environment environment) {
		return logErrorService.findByEnvironment(environment);
	}
}