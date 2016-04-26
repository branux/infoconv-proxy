package br.gov.serpro.infoconv.proxy.exception;

import java.io.Serializable;

public class PerfilInvalidoException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public PerfilInvalidoException() {
		super();
	}
	
	public PerfilInvalidoException(String error) {
		super(error);
	}
	
	public PerfilInvalidoException(String error, Throwable cause) {
		super(error,cause);
	}
	
	@Override
	public String getMessage() {		
		return (super.getMessage()!=null)? super.getMessage(): "Perfil inválido";
	}
	
	
	
}
