package br.gov.serpro.infoconv.proxy.rest;

import java.util.List;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import br.gov.serpro.infoconv.proxy.businesscontroller.ConsultaCNPJBC;
import br.gov.serpro.infoconv.ws.cnpj.CNPJPerfil1;
import br.gov.serpro.infoconv.ws.cnpj.CNPJPerfil2;
import br.gov.serpro.infoconv.ws.cnpj.CNPJPerfil3;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="cnpj: Consulta a CNPJ's para um perfil.")
@Path("cnpj")
public class CnpjResource {
	
	// TODO Para as consultas é necessário informar o cpf do consultante. Está
	// hardcoded na classe cnpjBC. Deveria vir no request.

	@Inject
	ConsultaCNPJBC cnpjBC;
	
	
	@ApiOperation(value="Consulta os CNPJ's para o Perfil 1")
	@ApiResponses(value = { 
			@ApiResponse(code = 401, message = "ACS - Erro xx - Acesso negado."),
		    @ApiResponse(code = 404, message = "CPF - Erro 04 – CPF não encontrado."),
			@ApiResponse(code = 412, message = "CPF's ou certificados inválidos"),
			@ApiResponse(code = 500, message = "Instabilidade nos servidores do infoconv")
			})
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("perfil1")
	public List<CNPJPerfil1> obterListaPerfil1(
			@ApiParam(value="Lista de CNPJ's. Apenas números e separados por ponto e vírgula.")
			@NotNull @QueryParam("listaCNPJ") String lista) throws Exception {
		List<CNPJPerfil1> resultado = cnpjBC.listarPerfil1(lista);
		return resultado;
	}
	
	@ApiOperation(value="Consulta os CNPJ's para o Perfil 2")
	@ApiResponses(value = { 
			@ApiResponse(code = 401, message = "ACS - Erro xx - Acesso negado."),
		    @ApiResponse(code = 404, message = "CPF - Erro 04 – CPF não encontrado."),
			@ApiResponse(code = 412, message = "CPF's ou certificados inválidos"),
			@ApiResponse(code = 500, message = "Instabilidade nos servidores do infoconv")
			})
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("perfil2")
	public List<CNPJPerfil2> obterListaPerfil2(
			@ApiParam(value="Lista de CNPJ's. Apenas números e separados por ponto e vírgula.")
			@NotNull @QueryParam("listaCNPJ") String lista) throws Exception {
		List<CNPJPerfil2> resultado = cnpjBC.listarPerfil2(lista);
		return resultado;
	}
	
	@ApiOperation(value="Consulta os CNPJ's para o Perfil 3")
	@ApiResponses(value = { 
			@ApiResponse(code = 401, message = "ACS - Erro xx - Acesso negado."),
		    @ApiResponse(code = 404, message = "CPF - Erro 04 – CPF não encontrado."),
			@ApiResponse(code = 412, message = "CPF's ou certificados inválidos"),
			@ApiResponse(code = 500, message = "Instabilidade nos servidores do infoconv")
			})
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("perfil3")
	public List<CNPJPerfil3> obterListaPerfil3(
			@ApiParam(value="Lista de CNPJ's. Apenas números e separados por ponto e vírgula.")
			@NotNull @QueryParam("listaCNPJ") String lista) throws Exception {
		List<CNPJPerfil3> resultado = cnpjBC.listarPerfil3(lista);
		return resultado;
	}
		

//	@GET
//	@Produces("application/json")
//	public Response find(@QueryParam("lista") String lista, @QueryParam("perfil") String perfil) throws Exception {
//		List<Object> resultado = cnpjBC.consultarListaDeCnpjPorPerfil(lista, perfil);
//		return Response.ok().entity(resultado).build();
//	}
//
//	@GET
//	@Path("{cnpj}")
//	@Produces("application/json")
//	public Response load(@PathParam("cnpj") String cnpj, @QueryParam("perfil") String perfil) throws Exception {
//		List<Object> resultado = cnpjBC.consultarListaDeCnpjPorPerfil(cnpj, perfil);
//		return Response.ok().entity(resultado.get(0)).build();
//	}

}
