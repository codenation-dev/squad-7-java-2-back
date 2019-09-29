package com.codenation.centralerros.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "END_USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Email
	@Size(max = 100)
	@NotNull(message="E-mail é obrigatório")
	private String email;

	@Size(max = 100)
	@NotNull(message="Password é obrigatório")
	private String password;

	@Size(max = 100)
	@NotNull(message="Nome é obrigatório")
	private String name;

	@CreatedDate
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime lastModifiedDate;
}
