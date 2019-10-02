package com.codenation.centralerros.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.codenation.centralerros.model.enums.Environment;
import com.codenation.centralerros.model.enums.Level;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class LogError {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 255)
	@NotNull(message="O Título é obrigatório")
	private String title;
	
	@Size(max = 500)
	@NotNull(message="A descrição do log é obrigatório")
	private String detail;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message="O Environment é obrigatório")
	private Environment environment;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message="O Level é obrigatório")
	private Level level;
	
	private Long frequencia;
	
	private Boolean archived;

	@Size(max = 100)
	@NotNull(message="Ip é obrigatório")
	private String ip;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime createdDate;
    
    @CreatedBy
	private String createdBy;
    
}
