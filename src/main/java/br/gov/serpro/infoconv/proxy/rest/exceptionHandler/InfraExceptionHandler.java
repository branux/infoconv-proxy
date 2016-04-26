package br.gov.serpro.infoconv.proxy.rest.exceptionHandler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.gov.serpro.infoconv.proxy.exception.InfraException;

@Provider
public class InfraExceptionHandler implements ExceptionMapper<InfraException> {

	@Override
	public Response toResponse(final InfraException exception) {
		return Response.status(Status.INTERNAL_SERVER_ERROR)
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