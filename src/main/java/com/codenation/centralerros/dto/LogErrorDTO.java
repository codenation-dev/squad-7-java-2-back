package com.codenation.centralerros.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.codenation.centralerros.model.LogError;
import com.codenation.centralerros.model.enums.Environment;
import com.codenation.centralerros.model.enums.Level;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LogErrorDTO {

    private Long id;
	
	@NotNull(message="O Título é obrigatório")
	private String title;
	
	@NotNull(message="A descrição do log é obrigatório")
	private String detail;
	
	@NotNull(message="O Environment é obrigatório")
	private String environment;
	
	@NotNull(message="O Level é obrigatório")
	private String level;
	
	private Long frequencia;
	
	private Boolean archived;
	
	@NotNull(message="Ip é obrigatório")
	private String ip;

	private LocalDateTime createdDate;
    
	private String createdBy;
	
	public LogErrorDTO() {
		super();
	}
	
	public LogErrorDTO(LogError logError) {
		super();
		this.id = logError.getId();
		this.title = logError.getTitle();
		this.detail = logError.getDetail();
		this.environment = logError.getEnvironment().getDescricao();
		this.level = logError.getLevel().getDescricao();
		this.frequencia = logError.getFrequencia();
		this.archived = logError.getArchived();
		this.ip = logError.getDetail();
		this.createdDate = logError.getCreatedDate();
		this.createdBy = logError.getCreatedBy();
	}
	
	public LogError toLogError() {
		return LogError.builder()
				.id(this.id)
				.title(this.title)
				.detail(this.detail)
				.level( Level.valueOf(this.level))
				.environment(Environment.valueOf(this.environment))
				.frequencia(this.frequencia)
				.archived(this.archived )
				.ip(this.ip)
				.createdDate(this.createdDate)
				.createdBy(this.createdBy)
				.build();
	}



	
}