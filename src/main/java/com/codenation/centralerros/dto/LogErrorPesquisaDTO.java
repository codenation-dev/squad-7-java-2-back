package com.codenation.centralerros.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogErrorPesquisaDTO {

	private String ip;
	private String detail;
	private String level;
	private String environment;
	private Boolean archived;

	public String getEnvironment() {
		return  environment == null ? null : environment.toUpperCase();
	}

	public String getDetail() {
		return detail == null ? null : detail.toUpperCase();
	}

	public String getLevel() {
		return level== null ? null : level.toUpperCase();
	}

	public String getIp() {
		return ip== null ? null : ip.toUpperCase();
	}
	
	public Boolean getArchived() {
		return archived;
	}

}