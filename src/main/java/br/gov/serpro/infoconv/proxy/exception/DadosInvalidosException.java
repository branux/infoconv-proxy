package br.gov.serpro.infoconv.proxy.exception;

import java.io.Serializable;

public class DadosInvalidosException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public DadosInvalidosException() {
		super();
	}
	
	public DadosInvalidosException(String error) {
		super(error);
	}
	
	public DadosInvalidosException(String error, Throwable cause) {
		super(error,cause);
	}
	
	
	
}
