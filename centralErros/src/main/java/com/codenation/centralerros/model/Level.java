package com.codenation.centralerros.model;

public enum Level {
	
	DEBUG(0),
	ERROR(1),
	WARNING(2);
	
	private Level(int value) {
		this.value = value;
	} 
	
	private int value;
	
	public int getValue() {
		return value;
	}

}
