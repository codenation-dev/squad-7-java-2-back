package com.codenation.centralerros.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogDetailPesquisaDTO {

	private String title;
	private String detail;
	private String level;

	private Boolean archived;

	public String getTitle() {
		return  title == null ? null : title.toUpperCase();
	}

	public String getDetail() {
		return detail == null ? null : detail.toUpperCase();
	}

	public String getLevel() {
		return level== null ? null : level.toUpperCase();
	}

	
	public Boolean getArchived() {
		return archived;
	}

}