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

import com.codenation.centralerros.dto.LogDetailDTO;
import com.codenation.centralerros.dto.LogDetailPesquisaDTO;
import com.codenation.centralerros.model.enums.Environment;
import com.codenation.centralerros.service.LogDetailService;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@ControllerAdvice
@RestController
@EnableWebMvc
@RequestMapping("/log")
@AllArgsConstructor
@Api(value = "central de erros")
public class LogDetailController {

	@Autowired
	private LogDetailService logDetailService;

	@PostMapping
	public void save(@Valid @RequestBody LogDetailDTO logDetail) {
		logDetailService.save( logDetail );
	}

	@GetMapping()
	public List<LogDetailDTO> findAll() {
		return logDetailService.findAll();
	}
	
	@GetMapping(value = "filter")
	public Page<LogDetailDTO> findAll(LogDetailPesquisaDTO dto,
			  @RequestParam(
	                    value = "page",
	                    required = false,
	                    defaultValue = "0") int page,
	            @RequestParam(
	                    value = "size",
	                    required = false,
	                    defaultValue = "10") int size) {
		return logDetailService.pesquisaLogDetailAvancada(dto,page,size);
		
	}

	@GetMapping("/{id}")
	public LogDetailDTO findById(@PathVariable("id") Long id) {
		return logDetailService.findById( id );
	}

	@GetMapping(value = "/environment")
	public List<LogDetailDTO> findByEnvironment(Environment environment) {
		return logDetailService.findByOriginEnvironment( environment );
	}
}