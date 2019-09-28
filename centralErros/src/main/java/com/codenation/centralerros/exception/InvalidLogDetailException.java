package com.codenation.centralerros.exception;

public class InvalidLogDetailException extends RuntimeException {
	public InvalidLogDetailException() {
		super( "Existem campos faltantes ");
	}
}
