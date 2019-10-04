package com.codenation.centralerros.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codenation.centralerros.dto.LogErrorDTO;
import com.codenation.centralerros.dto.LogErrorPesquisaDTO;
import com.codenation.centralerros.dto.PageDTO;
import com.codenation.centralerros.model.LogError;
import com.codenation.centralerros.model.enums.Environment;
import com.codenation.centralerros.model.enums.Level;
import com.codenation.centralerros.model.enums.TipoOrdenacao;
import com.codenation.centralerros.repository.LogErrorRepository;

@Service
public class LogErrorService {

	@Autowired
	private LogErrorRepository logErrorRepository;

	public LogErrorDTO save(LogErrorDTO logErrorDTO) {
		return new LogErrorDTO(logErrorRepository.save(logErrorDTO.toLogError()));
	}

	public void delete(Long id) {
		logErrorRepository.deleteById(id);
	}

	public List<LogErrorDTO> findAll() {
		return logErrorRepository.findAll().stream().map(LogErrorDTO::new).collect(Collectors.toList());
	}

	public Page<LogErrorDTO> pesquisaLogAvancada(LogErrorPesquisaDTO dto, PageDTO page) {

		Sort sort = null;
		if (page.getPageOrderBy() != null) {
			if (page.getPageDirection() == TipoOrdenacao.DESC) {
				sort = Sort.by(page.getPageOrderBy().toLowerCase()).descending();
			} else {
				sort = Sort.by(page.getPageOrderBy().toLowerCase()).ascending();
			}

		}
		PageRequest pageRequest = PageRequest.of(page.getPageNumber(), page.getPageSize(), sort);

		Page<LogError> filter = null;

		if (dto != null) {
			Level level = null;
			Environment ambiente = null;
			
			if(dto.getEnvironment() != null) {
				ambiente = Environment.valueOf(dto.getEnvironment());
			}
			if(dto.getLevel() != null) {
				level = Level.valueOf(dto.getLevel());
			}
			filter = this.logErrorRepository.pesquisaLogErrorAvancada(dto.getIp(), dto.getDetail(),level,
					ambiente, pageRequest);
		} else {
			filter = this.logErrorRepository.findAll(pageRequest);
		}
		return filter.map(e -> new LogErrorDTO(e));
	}

	public LogErrorDTO findById(Long id) {
		return logErrorRepository.findById(id).map(LogErrorDTO::new).orElse(null);
	}

	public List<LogErrorDTO> findByEnvironment(Environment environment) {
		return logErrorRepository.findByEnvironment(environment).stream().map(LogErrorDTO::new)
				.collect(Collectors.toList());
	}

	/*
	 * public void validateLog(LogErrorDTO logErrorDTO) { if
	 * (logErrorDTO.getDetail().isEmpty() || logErrorDTO.getDetail() == null ||
	 * logErrorDTO.getLevel().isEmpty() || logErrorDTO.getLevel() == null ||
	 * logErrorDTO.getTimeEvent() == null || logErrorDTO.getTitle().isEmpty() ||
	 * logErrorDTO.getTitle() == null || ( logErrorDTO.getLogOrigin() != null ||
	 * logErrorDTO.getLogOrigin().getEnvironment() == null ||
	 * logErrorDTO.getLogOrigin().getName().isEmpty() ||
	 * logErrorDTO.getLogOrigin().getName() == null )) { throw new
	 * InvalidLogDetailException(); } }
	 */

}
