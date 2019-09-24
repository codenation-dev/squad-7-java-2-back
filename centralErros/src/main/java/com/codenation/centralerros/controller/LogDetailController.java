package com.codenation.centralerros.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codenation.centralerros.controller.advice.ResourceNotFoundException;
import com.codenation.centralerros.dto.LogDetailDTO;
import com.codenation.centralerros.mappers.LogDetailMapper;
import com.codenation.centralerros.model.Environment;
import com.codenation.centralerros.model.LogDetail;
import com.codenation.centralerros.repository.LogDetailRepository;
import com.google.gson.Gson;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/logOrigin")
public class LogDetailController {

	@Autowired
	private LogDetailRepository logDetailRepository;

	@Autowired
	private LogDetailMapper mapper;

	@PostMapping
	@ApiOperation("Cria um novo Log")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Log criado com sucesso") })
	public ResponseEntity<LogDetail> create(@Valid @RequestBody LogDetail logDetail) {
		return new ResponseEntity<LogDetail>(this.logDetailRepository.save(logDetail), HttpStatus.CREATED);
	}

	@GetMapping
//    @ApiOperation("Lista todos os log")
	public Iterable<LogDetail> findAll(Pageable pageable) {
		return this.logDetailRepository.findAll(pageable);
	}

	@GetMapping
	@ApiOperation("Lista todos os logs de acordo com os parametros do logDetail")
	public Iterable<LogDetail> findAll(@RequestParam(value = "logDetailDTO") String logDetailJson, Pageable pageable) {
		Gson gson = new Gson();
		LogDetailDTO logDetailDTO = gson.fromJson(logDetailJson, LogDetailDTO.class);
		LogDetail logDetail = mapper.map(logDetailDTO);
		return this.logDetailRepository.findAll(Example.of(logDetail), pageable);
	}

	@GetMapping("/{id}")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Log não encontrado"), @ApiResponse(code = 200, message = "Log encontrado")})
	public ResponseEntity<LogDetail> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<LogDetail>(
				this.logDetailRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("LogOrigin")),
				HttpStatus.OK);
	}

	@GetMapping
	@ApiOperation("Lista todos os logs por ambiente")
	public Iterable<LogDetail> findByEnvironment(Environment env, Pageable pageable) {
		return this.logDetailRepository.findByOriginEnvironment(env, pageable);
	}
}