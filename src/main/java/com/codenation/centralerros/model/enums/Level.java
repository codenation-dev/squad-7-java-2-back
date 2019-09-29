package com.codenation.centralerros.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Level {
	
	DEBUG(0, "DEBUG"),
	ERROR(1, "ERROR"),
	WARNING(2, "WARNING");
	
	private int codigo;
	private String descricao;
	
	private Level(int cod, String descricao) {
		this.codigo = cod;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static Level toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (Level x : Level.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código Level inválido: " + cod);
	}

}
