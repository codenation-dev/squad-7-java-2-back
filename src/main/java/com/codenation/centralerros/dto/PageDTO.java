package com.codenation.centralerros.dto;

import com.codenation.centralerros.model.enums.TipoOrdenacao;

public class PageDTO {
	private Integer pageSize;
	private Integer pageNumber;
	private String pageOrderBy;
	private TipoOrdenacao pageDirection;
	
	public PageDTO(Integer pageSize, Integer pageNumber, String pageOrderBy, TipoOrdenacao pageDirection) {
		super();
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		this.pageOrderBy = pageOrderBy;
		this.pageDirection = pageDirection;
	}
	
	public PageDTO() {
		super();
		this.pageSize = 10;
		this.pageNumber = 0;
		this.pageOrderBy = "level";
		this.pageDirection = TipoOrdenacao.ASC;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getPageOrderBy() {
		return pageOrderBy;
	}

	public void setPageOrderBy(String pageOrderBy) {
		this.pageOrderBy = pageOrderBy;
	}

	public TipoOrdenacao getPageDirection() {
		return pageDirection;
	}

	public void setPageDirection(TipoOrdenacao pageDirection) {
		this.pageDirection = pageDirection;
	}
}
