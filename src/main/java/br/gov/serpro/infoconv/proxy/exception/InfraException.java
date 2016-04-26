package br.gov.serpro.infoconv.proxy.exception;

import java.io.Serializable;

public class InfraException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public InfraException() {
		super();
	}
	
	public InfraException(String error) {
		super(error);
	}
	
	public InfraException(String error, Throwable cause) {
		super(error,cause);
	}
	
	
	
}
