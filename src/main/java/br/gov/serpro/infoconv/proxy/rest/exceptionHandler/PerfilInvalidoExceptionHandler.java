package br.gov.serpro.infoconv.proxy.rest.exceptionHandler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.gov.serpro.infoconv.proxy.exception.PerfilInvalidoException;

@Provider
public class PerfilInvalidoExceptionHandler implements ExceptionMapper<PerfilInvalidoException> {

	@Override
	public Response toResponse(final PerfilInvalidoException exception) {
		return Response.status(Status.BAD_REQUEST)
				.entity(new ErrorMessage(exception.getMessage()))
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	
	public class ErrorMessage {
		public String error;
		public ErrorMessage(String error) {
			this.error = error;
		}
	}
}