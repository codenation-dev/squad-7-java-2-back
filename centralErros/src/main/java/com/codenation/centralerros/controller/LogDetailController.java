package com.codenation.centralerros.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codenation.centralerros.dto.LogDetailDTO;
import com.codenation.centralerros.model.Environment;
import com.codenation.centralerros.repository.LogDetailRepository;
import com.codenation.centralerros.service.LogDetailService;

@RestController
@RequestMapping("/log")
public class LogDetailController {

	@Autowired
	private LogDetailRepository logDetailRepository;

	@Autowired
	private LogDetailService logDetailService;

	@PostMapping
	public void save(@Valid @RequestBody LogDetailDTO logDetail) {
		logDetailService.save( logDetail );
	}

	@GetMapping(value = "/all")
	public List<LogDetailDTO> findAll() {
		return logDetailService.findAll();
	}

	@GetMapping(value = "filter")
	public List<LogDetailDTO> findAll(@RequestParam(value = "logDetailDTO") LogDetailDTO logDetailDTO) {
		return null;
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