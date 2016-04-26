package br.gov.serpro.infoconv.proxy.rest.exceptionHandler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.gov.serpro.infoconv.proxy.exception.AcessoNegadoException;

@Provider
public class AcessoNegadoExceptionHandler implements ExceptionMapper<AcessoNegadoException> {

	@Override
	public Response toResponse(final AcessoNegadoException exception) {
		return Response.status(Status.UNAUTHORIZED)
				.entity(new ErrorMessage(exception.getMessage()))
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	
	public class ErrorMessage {
		private String error;

		public ErrorMessage(String error) {
			this.error = error;
		}

		public String getError() {
			return error;
		}
	}
}