package br.gov.serpro.infoconv.proxy.rest;

import java.util.List;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import br.gov.serpro.infoconv.proxy.businesscontroller.ConsultaCpfBC;
import br.gov.serpro.infoconv.proxy.rest.dto.cpf.Perfil1;
import br.gov.serpro.infoconv.proxy.rest.dto.cpf.Perfil2;
import br.gov.serpro.infoconv.ws.cpf.PessoaPerfil1A;
import br.gov.serpro.infoconv.ws.cpf.PessoaPerfil2A;
import br.gov.serpro.infoconv.ws.cpf.PessoaPerfil3;
import br.gov.serpro.infoconv.ws.cpf.PessoaPerfil3A;
import br.gov.serpro.infoconv.ws.cpf.PessoaPerfilD;
import br.gov.serpro.infoconv.ws.cpf.PessoaPerfilD2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "cpf : Consulta a CPF's para um perfil.")
@Path("cpf")
public class CpfResource {

	// TODO Para as consultas é necessário informar o cpf do consultante. Está
	// hardcoded na classe cpfBC. Deveria vir no request.

	@Inject
	ConsultaCpfBC cpfBC;

	@ApiOperation(value = "Consulta os CPF's para o Perfil 1")
	@ApiResponses(value = { @ApiResponse(code = 401, message = "ACS - Erro xx - Acesso negado."),
			@ApiResponse(code = 404, message = "CPF - Erro 04 – CPF não encontrado."),
			@ApiResponse(code = 412, message = "CPF's ou certificados inválidos"),
			@ApiResponse(code = 500, message = "Instabilidade nos servidores do infoconv") })
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("perfil1")
	public List<Perfil1> obterListaPerfil1(
			@ApiParam(value = "Lista de CPFs a serem consultados sem formatação (apenas números) com 11 posições. O número máximo de CPFs em uma consulta é de 50. Caso seja consultado mais de 1 CPF, estes devem ser separados por ponto e vírgula. Ex: 00000000001;00000000002;00000000003") @NotNull @QueryParam("listaCPF") String lista)
			throws Exception {
		List<Perfil1> resultado = cpfBC.listarPerfil1(lista);
		return resultado;
	}

	@ApiOperation(value = "Consulta os CPF's para o Perfil 1A")
	@ApiResponses(value = { @ApiResponse(code = 401, message = "ACS - Erro xx - Acesso negado."),
			@ApiResponse(code = 404, message = "CPF - Erro 04 – CPF não encontrado."),
			@ApiResponse(code = 412, message = "CPF's ou certificados inválidos"),
			@ApiResponse(code = 500, message = "Instabilidade nos servidores do infoconv") })
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("perfil1A")
	public List<PessoaPerfil1A> obterListaPerfil1A(
			@ApiParam(value = "Lista de CPFs a serem consultados sem formatação (apenas números) com 11 posições. O número máximo de CPFs em uma consulta é de 50. Caso seja consultado mais de 1 CPF, estes devem ser separados por ponto e vírgula. Ex: 00000000001;00000000002;00000000003") @QueryParam("listaCPF") String lista)
			throws Exception {
		List<PessoaPerfil1A> resultado = cpfBC.listarPerfil1A(lista);
		return resultado;
	}

	@ApiOperation(value = "Consulta os CPF's para o Perfil 2")
	@ApiResponses(value = { @ApiResponse(code = 401, message = "ACS - Erro xx - Acesso negado."),
			@ApiResponse(code = 404, message = "CPF - Erro 04 – CPF não encontrado."),
			@ApiResponse(code = 412, message = "CPF's ou certificados inválidos"),
			@ApiResponse(code = 500, message = "Instabilidade nos servidores do infoconv") })
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("perfil2")
	public List<Perfil2> obterListaPerfil2(
			@ApiParam(value = "Lista de CPFs a serem consultados sem formatação (apenas números) com 11 posições. O número máximo de CPFs em uma consulta é de 50. Caso seja consultado mais de 1 CPF, estes devem ser separados por ponto e vírgula. Ex: 00000000001;00000000002;00000000003") @QueryParam("listaCPF") String lista)
			throws Exception {
		List<Perfil2> resultado = cpfBC.listarPerfil2(lista);
		return resultado;
	}

	@ApiOperation(value = "Consulta os CPF's para o Perfil 2A")
	@ApiResponses(value = { @ApiResponse(code = 401, message = "ACS - Erro xx - Acesso negado."),
			@ApiResponse(code = 404, message = "CPF - Erro 04 – CPF não encontrado."),
			@ApiResponse(code = 412, message = "CPF's ou certificados inválidos"),
			@ApiResponse(code = 500, message = "Instabilidade nos servidores do infoconv") })
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("perfil2A")
	public List<PessoaPerfil2A> obterListaPerfil2A(
			@ApiParam(value = "Lista de CPFs a serem consultados sem formatação (apenas números) com 11 posições. O número máximo de CPFs em uma consulta é de 50. Caso seja consultado mais de 1 CPF, estes devem ser separados por ponto e vírgula. Ex: 00000000001;00000000002;00000000003") @QueryParam("listaCPF") String lista)
			throws Exception {
		List<PessoaPerfil2A> resultado = cpfBC.listarPerfil2A(lista);
		return resultado;
	}

	@ApiOperation(value = "Consulta os CPF's para o Perfil 3")
	@ApiResponses(value = { @ApiResponse(code = 401, message = "ACS - Erro xx - Acesso negado."),
			@ApiResponse(code = 404, message = "CPF - Erro 04 – CPF não encontrado."),
			@ApiResponse(code = 412, message = "CPF's ou certificados inválidos"),
			@ApiResponse(code = 500, message = "Instabilidade nos servidores do infoconv") })
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("perfil3")
	public List<PessoaPerfil3> obterListaPerfil3(
			@ApiParam(value = "Lista de CPFs a serem consultados sem formatação (apenas números) com 11 posições. O número máximo de CPFs em uma consulta é de 50. Caso seja consultado mais de 1 CPF, estes devem ser separados por ponto e vírgula. Ex: 00000000001;00000000002;00000000003") @QueryParam("listaCPF") String lista)
			throws Exception {
		List<PessoaPerfil3> resultado = cpfBC.listarPerfil3(lista);
		return resultado;
	}

	@ApiOperation(value = "Consulta os CPF's para o Perfil 3A")
	@ApiResponses(value = { @ApiResponse(code = 401, message = "ACS - Erro xx - Acesso negado."),
			@ApiResponse(code = 404, message = "CPF - Erro 04 – CPF não encontrado."),
			@ApiResponse(code = 412, message = "CPF's ou certificados inválidos"),
			@ApiResponse(code = 500, message = "Instabilidade nos servidores do infoconv") })
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("perfil3A")
	public List<PessoaPerfil3A> obterListaPerfil3A(
			@ApiParam(value = "Lista de CPFs a serem consultados sem formatação (apenas números) com 11 posições. O número máximo de CPFs em uma consulta é de 50. Caso seja consultado mais de 1 CPF, estes devem ser separados por ponto e vírgula. Ex: 00000000001;00000000002;00000000003") @QueryParam("listaCPF") String lista)
			throws Exception {
		List<PessoaPerfil3A> resultado = cpfBC.listarPerfil3A(lista);
		return resultado;
	}

	@ApiOperation(value = "Consulta os CPF's para o Perfil D")
	@ApiResponses(value = { @ApiResponse(code = 401, message = "ACS - Erro xx - Acesso negado."),
			@ApiResponse(code = 404, message = "CPF - Erro 04 – CPF não encontrado."),
			@ApiResponse(code = 412, message = "CPF's ou certificados inválidos"),
			@ApiResponse(code = 500, message = "Instabilidade nos servidores do infoconv") })
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("perfilD")
	public List<PessoaPerfilD> obterListaPerfilD(
			@ApiParam(value = "Lista de CPFs a serem consultados sem formatação (apenas números) com 11 posições. O número máximo de CPFs em uma consulta é de 50. Caso seja consultado mais de 1 CPF, estes devem ser separados por ponto e vírgula. Ex: 00000000001;00000000002;00000000003") @QueryParam("listaCPF") String lista)
			throws Exception {
		List<PessoaPerfilD> resultado = cpfBC.listarPerfilD(lista);
		return resultado;
	}

	@ApiOperation(value = "Consulta os CPF's para o Perfil D2")
	@ApiResponses(value = { @ApiResponse(code = 401, message = "ACS - Erro xx - Acesso negado."),
			@ApiResponse(code = 404, message = "CPF - Erro 04 – CPF não encontrado."),
			@ApiResponse(code = 412, message = "CPF's ou certificados inválidos"),
			@ApiResponse(code = 500, message = "Instabilidade nos servidores do infoconv") })
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("perfilD2")
	public List<PessoaPerfilD2> obterListaPerfilD2(
			@ApiParam(value = "Lista de CPFs a serem consultados sem formatação (apenas números) com 11 posições. O número máximo de CPFs em uma consulta é de 50. Caso seja consultado mais de 1 CPF, estes devem ser separados por ponto e vírgula. Ex: 00000000001;00000000002;00000000003") @QueryParam("listaCPF") String lista)
			throws Exception {
		List<PessoaPerfilD2> resultado = cpfBC.listarPerfilD2(lista);
		return resultado;
	}

	// /**
	// * Consulta genérica de pessoa física considerando o parametro perfil.
	// * @param lista
	// * @param perfil (p1,p1a,p2,p2a,p3
	// * @return
	// * @throws Exception
	// */
	// @GET
	// @Produces("application/json")
	// public Response obterLista(
	// @QueryParam("lista") String lista,
	// @QueryParam("perfil") String perfil) throws Exception {
	// List<Object> resultado = cpfBC.consultarListaDeCpfPorPerfil(lista,
	// perfil);
	// return Response.ok().entity(resultado).build();
	// }

}
