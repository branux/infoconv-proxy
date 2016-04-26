package br.gov.serpro.infoconv.proxy.rest;

import java.lang.reflect.Field;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.gov.serpro.infoconv.proxy.exception.AcessoNegadoException;
import br.gov.serpro.infoconv.proxy.exception.CpfNaoEncontradoException;
import br.gov.serpro.infoconv.proxy.exception.DadosInvalidosException;
import br.gov.serpro.infoconv.proxy.exception.InfraException;
import br.gov.serpro.infoconv.proxy.exception.PerfilInvalidoException;
import br.gov.serpro.infoconv.proxy.util.InfoconvConfig;
import br.gov.serpro.infoconv.ws.cpf.ArrayOfPessoaPerfil1;
import br.gov.serpro.infoconv.ws.cpf.ArrayOfPessoaPerfil1A;
import br.gov.serpro.infoconv.ws.cpf.ArrayOfPessoaPerfil2;
import br.gov.serpro.infoconv.ws.cpf.ArrayOfPessoaPerfil2A;
import br.gov.serpro.infoconv.ws.cpf.ArrayOfPessoaPerfil3;
import br.gov.serpro.infoconv.ws.cpf.ArrayOfPessoaPerfil3A;
import br.gov.serpro.infoconv.ws.cpf.ArrayOfPessoaPerfilD;
import br.gov.serpro.infoconv.ws.cpf.ArrayOfPessoaPerfilD2;
import br.gov.serpro.infoconv.ws.cpf.PessoaPerfil1;

@Path("cpf")
public class CpfResource {

	/** Classe de configuração do infoconv. */
	@Inject
	InfoconvConfig infoconv;

	private static final String CPF_CONSULTANTE = "79506240949";

	@GET
	@Produces("application/json")
	public List<PessoaPerfil1> find(@QueryParam("lista") String lista) throws Exception {
		ArrayOfPessoaPerfil1 aPerfil1 = infoconv.consultarCPFSoap.consultarCPFP1(lista, CPF_CONSULTANTE);
		return aPerfil1.getPessoaPerfil1();
	}

	@GET
	@Path("{cpf}")
	@Produces("application/json")
	public Response load(@PathParam("cpf") String cpf, @QueryParam("perfil") String perfil) throws Exception {
		ResponseBuilder response = Response.noContent();

		if (perfil == null || "P1".equals(perfil.toUpperCase())) {
			ArrayOfPessoaPerfil1 aPerfil1 = infoconv.consultarCPFSoap.consultarCPFP1(cpf, CPF_CONSULTANTE);
			response = Response.ok().entity(aPerfil1.getPessoaPerfil1().get(0));
		} else if ("P1A".equals(perfil.toUpperCase())) {
			ArrayOfPessoaPerfil1A aPerfil1A = infoconv.consultarCPFSoap.consultarCPFP1A(cpf, CPF_CONSULTANTE);
			response = Response.ok().entity(aPerfil1A.getPessoaPerfil1A().get(0));
		} else if ("P2".equals(perfil.toUpperCase())) {
			ArrayOfPessoaPerfil2 aPerfil2 = infoconv.consultarCPFSoap.consultarCPFP2(cpf, CPF_CONSULTANTE);
			response = Response.ok().entity(aPerfil2.getPessoaPerfil2().get(0));
		} else if ("P2A".equals(perfil.toUpperCase())) {
			ArrayOfPessoaPerfil2A aPerfil2A = infoconv.consultarCPFSoap.consultarCPFP2A(cpf, CPF_CONSULTANTE);
			response = Response.ok().entity(aPerfil2A.getPessoaPerfil2A().get(0));
		} else if ("P3".equals(perfil.toUpperCase())) {
			ArrayOfPessoaPerfil3 aPerfil3 = infoconv.consultarCPFSoap.consultarCPFP3(cpf, CPF_CONSULTANTE);
			response = Response.ok().entity(aPerfil3.getPessoaPerfil3().get(0));
		} else if ("P3A".equals(perfil.toUpperCase())) {
			ArrayOfPessoaPerfil3A aPerfil3A = infoconv.consultarCPFSoap.consultarCPFP3A(cpf, CPF_CONSULTANTE);
			response = Response.ok().entity(aPerfil3A.getPessoaPerfil3A().get(0));
		} else if ("PD".equals(perfil.toUpperCase())) {
			ArrayOfPessoaPerfilD aPerfilD = infoconv.consultarCPFSoap.consultarCPFPD(cpf, CPF_CONSULTANTE);
			response = Response.ok().entity(aPerfilD.getPessoaPerfilD().get(0));
		} else if ("PD2".equals(perfil.toUpperCase())) {
			ArrayOfPessoaPerfilD2 aPerfilD2 = infoconv.consultarCPFSoap.consultarCPFPD2(cpf, CPF_CONSULTANTE);
			response = Response.ok().entity(aPerfilD2.getPessoaPerfilD2().get(0));
		} else {
			throw new PerfilInvalidoException();
		}

		verificarErros(response);

		return response.build();
	}

	/**
	 * Verifica a propriedade ERRO para saber se houve algum problema na
	 * consulta.
	 * 
	 * Documentação dos códigos de Erros: https://github.com/infoconv/infoconv-ws
	 * 
	 * @param response
	 * @throws AcessoNegadoException
	 * @throws CpfNaoEncontradoException
	 * @throws DadosInvalidosException 
	 * @throws InfraException 
	 */
	private void verificarErros(final ResponseBuilder response)
			throws AcessoNegadoException, CpfNaoEncontradoException, DadosInvalidosException, InfraException {

		try {
			Object retorno = response.clone().build().getEntity();
			Class<?> c = retorno.getClass();
			Field erroField = c.getDeclaredField("erro");
			erroField.setAccessible(true);
			String erroMsg = (String) erroField.get(retorno);
			if (erroMsg.indexOf("ACS - Erro") > -1) {
				throw new AcessoNegadoException(erroMsg);
			} else if (erroMsg.indexOf("CPF - Erro 04") > -1) {
				throw new CpfNaoEncontradoException(erroMsg);
			} else if (erroMsg.indexOf("CPF - Erro 02") > -1 ||
					erroMsg.indexOf("CPF - Erro 06") > -1 ||
					erroMsg.indexOf("CPF - Erro 08") > -1 
					) {
				throw new DadosInvalidosException(erroMsg);
			} else if (erroMsg.indexOf("CPF - Erro 01") > -1 ||
					erroMsg.indexOf("CPF - Erro 03") > -1 ||
					erroMsg.indexOf("CPF - Erro 00") > -1 
					) {
				throw new InfraException(erroMsg);
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}

}
