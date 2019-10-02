package com.codenation.centralerros.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.codenation.centralerros.dto.LogErrorDTO;
import com.codenation.centralerros.dto.LogErrorPesquisaDTO;
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
	public void save(@Valid @RequestBody LogErrorDTO logError) {
		logErrorService.save( logError );
	}

	@GetMapping()
	public List<LogErrorDTO> findAll() {
		return logErrorService.findAll();
	}
	
	@GetMapping(value = "filter")
	public Page<LogErrorDTO> findAll(LogErrorPesquisaDTO dto,
			  @RequestParam(
	                    value = "page",
	                    required = false,
	                    defaultValue = "0") int page,
	            @RequestParam(
	                    value = "size",
	                    required = false,
	                    defaultValue = "10") int size) {
		return logErrorService.pesquisaLogAvancada(dto, page, size);
		
	}

	@GetMapping("/{id}")
	public LogErrorDTO findById(@PathVariable("id") Long id) {
		return logErrorService.findById( id );
	}

	@GetMapping(value = "/environment")
	public List<LogErrorDTO> findByEnvironment(Environment environment) {
		return logErrorService.findByEnvironment( environment );
	}
}