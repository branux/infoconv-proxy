package br.gov.serpro.infoconv.proxy.exception;

import java.io.Serializable;

public class CpfNaoEncontradoException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public CpfNaoEncontradoException() {
		super();
	}
	
	public CpfNaoEncontradoException(String error) {
		super(error);
	}
	
	public CpfNaoEncontradoException(String error, Throwable cause) {
		super(error,cause);
	}
	
	
	
}
