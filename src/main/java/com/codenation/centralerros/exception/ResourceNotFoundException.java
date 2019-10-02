package com.codenation.centralerros.exception;

public class ResourceNotFoundException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String resourceName){
        super("Resource: " + resourceName + " not found");
    }

}
