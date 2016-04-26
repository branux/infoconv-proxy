package br.gov.serpro.infoconv.proxy.exception;

import java.io.Serializable;

public class AcessoNegadoException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public AcessoNegadoException() {
		super();
	}
	
	public AcessoNegadoException(String error) {
		super(error);
	}
	
	public AcessoNegadoException(String error, Throwable cause) {
		super(error,cause);
	}
	
	
	
}
