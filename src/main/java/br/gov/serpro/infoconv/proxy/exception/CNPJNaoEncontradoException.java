package br.gov.serpro.infoconv.proxy.exception;

import java.io.Serializable;

public class CNPJNaoEncontradoException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public CNPJNaoEncontradoException() {
		super();
	}
	
	public CNPJNaoEncontradoException(String error) {
		super(error);
	}
	
	public CNPJNaoEncontradoException(String error, Throwable cause) {
		super(error,cause);
	}
	
	
	
}
