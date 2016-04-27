package br.gov.serpro.infoconv.proxy.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import br.gov.serpro.infoconv.proxy.businesscontroller.ConsultaCNPJBC;

@Path("cnpj")
public class CnpjResource {
	
	// TODO Para as consultas é necessário informar o cpf do consultante. Está
	// hardcoded na classe cnpjBC. Deveria vir no request.

	@Inject
	ConsultaCNPJBC cnpjBC;

	@GET
	@Produces("application/json")
	public Response find(@QueryParam("lista") String lista, @QueryParam("perfil") String perfil) throws Exception {
		List<Object> resultado = cnpjBC.consultarListaDeCnpjPorPerfil(lista, perfil);
		return Response.ok().entity(resultado).build();
	}

	@GET
	@Path("{cnpj}")
	@Produces("application/json")
	public Response load(@PathParam("cnpj") String cnpj, @QueryParam("perfil") String perfil) throws Exception {
		List<Object> resultado = cnpjBC.consultarListaDeCnpjPorPerfil(cnpj, perfil);
		return Response.ok().entity(resultado.get(0)).build();
	}

}
