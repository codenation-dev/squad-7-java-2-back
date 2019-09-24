package com.codenation.centralerros.dto;

public class LogDetailDTO {

    private Long id;
    private String title;
    private String detail;
    private String level;
    private String environment;
    private Boolean archived;
	private String timeEvent;
	private String createdDate;
	private String createdBy;

	public LogDetailDTO() {
	}

	public LogDetailDTO(Long id, String title, String detail, String level, String environment, Boolean archived,
			String timeEvent, String createdDate, String createdBy) {
		super();
		this.id = id;
		this.title = title;
		this.detail = detail;
		this.level = level;
		this.environment = environment;
		this.archived = archived;
		this.timeEvent = timeEvent;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

	public String getTimeEvent() {
		return timeEvent;
	}

	public void setTimeEvent(String timeEvent) {
		this.timeEvent = timeEvent;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
    
}