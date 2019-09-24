package com.codenation.centralerros.model;

public enum Environment {
	
	DEVELOPMENT(0),
	TEST(1),
	PRODUCTION(2);
	
	private Environment(int value) {
		this.value = value;
	} 
	
	private int value;
	
	public int getValue() {
		return value;
	}

}
