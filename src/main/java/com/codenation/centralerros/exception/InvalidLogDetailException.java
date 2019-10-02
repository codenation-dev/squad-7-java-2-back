package com.codenation.centralerros.exception;

public class InvalidLogDetailException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidLogDetailException() {
		super( "Existem campos faltantes ");
	}
}
