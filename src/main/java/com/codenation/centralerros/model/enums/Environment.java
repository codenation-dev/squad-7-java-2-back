package com.codenation.centralerros.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Environment {
	
	DEVELOPMENT(0, "DEVELOPMENT"),
	TEST(1, "TEST"),
	PRODUCTION(2, "PRODUCTION");
	
	
	private int codigo;
	private String descricao;
	
	private Environment(int cod, String descricao) {
		this.codigo = cod;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static Environment toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (Environment x : Environment.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código Environment inválido: " + cod);
	}


}
