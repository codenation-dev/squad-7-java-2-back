package com.codenation.centralerros.model.enums;

public enum TipoOrdenacao {
	ASC("ASC"),
	DESC("DESC");
	
	private final String directionCode;

	private TipoOrdenacao(String direction) {
		this.directionCode = direction;
	}

	public String getDirectionCode() {
		return this.directionCode;
	}
}
