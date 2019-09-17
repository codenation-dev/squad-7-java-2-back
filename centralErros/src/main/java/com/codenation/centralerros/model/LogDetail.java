package com.codenation.centralerros.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LogDetail {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String detail;
	
	private Level level;
	
	private Boolean archived;
	
	private LocalDateTime timeEvent;
	
	private LocalDateTime createdDate;
	
	private String createdBy;
	
	@ManyToOne
	private LogOrigin origin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public LogOrigin getOrigin() {
		return origin;
	}

	public void setOrigin(LogOrigin origin) {
		this.origin = origin;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

	public LocalDateTime getTimeEvent() {
		return timeEvent;
	}

	public void setTimeEvent(LocalDateTime timeEvent) {
		this.timeEvent = timeEvent;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	

}
