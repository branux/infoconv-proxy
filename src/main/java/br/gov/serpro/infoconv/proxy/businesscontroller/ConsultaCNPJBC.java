package br.gov.serpro.infoconv.proxy.businesscontroller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.serpro.infoconv.proxy.exception.AcessoNegadoException;
import br.gov.serpro.infoconv.proxy.exception.CNPJNaoEncontradoException;
import br.gov.serpro.infoconv.proxy.exception.CpfNaoEncontradoException;
import br.gov.serpro.infoconv.proxy.exception.DadosInvalidosException;
import br.gov.serpro.infoconv.proxy.exception.InfraException;
import br.gov.serpro.infoconv.proxy.exception.PerfilInvalidoException;
import br.gov.serpro.infoconv.proxy.rest.dto.cnpj.Perfil1CNPJ;
import br.gov.serpro.infoconv.proxy.rest.dto.cnpj.Perfil2CNPJ;
import br.gov.serpro.infoconv.proxy.rest.dto.cnpj.Perfil3CNPJ;
import br.gov.serpro.infoconv.proxy.util.InfoconvConfig;
import br.gov.serpro.infoconv.ws.cnpj.ArrayOfCNPJPerfil1;
import br.gov.serpro.infoconv.ws.cnpj.ArrayOfCNPJPerfil2;
import br.gov.serpro.infoconv.ws.cnpj.ArrayOfCNPJPerfil3;
import br.gov.serpro.infoconv.ws.cnpj.CNPJPerfil1;
import br.gov.serpro.infoconv.ws.cnpj.CNPJPerfil2;
import br.gov.serpro.infoconv.ws.cnpj.CNPJPerfil3;

/**
 * Classe responsável por interagir com o componente infoconv-ws para obter as
 * consultas de cnpj e transformar os erros previstos em exceções.
 *
 */
@BusinessController
public class ConsultaCNPJBC {

	/** Classe de configuração do infoconv. */
	@Inject
	InfoconvConfig infoconv;

	private static final String CPF_CONSULTANTE = "79506240949";

	/**
	 * Verifica a propriedade ERRO para saber se houve algum problema na
	 * consulta.
	 * 
	 * Como se trata de um webservice sempre retorna com codigo http 200 e
	 * dentro da msg de retorno o campo "erro" informa se teve algum problema.
	 * 
	 * Alguns "erros" são na verdade avisos por isso não levantam exceção. segue
	 * os erros que levantam exceção:
	 * 
	 * - AcessoNegadoException: Todos os erros que começãm com ACS - Erro. Podem
	 * ser por falta de permissão ou algum problema com certificado. A mensagem
	 * explica qual o problema.
	 * 
	 * - CNPJNaoEncontradoException: Quando o cpf não está na base. Erros: CPJ
	 * 04
	 * 
	 * - DadosInvalidosException: Qualquer problema de validação no servidor.
	 * Erros: CPJ 02,06 e 11
	 * 
	 * - InfraException: Erros no lado do servidor (WS) Erros: CPF 00 , 01, 03,
	 * 08, 09
	 * 
	 * Documentação dos códigos de Erros:
	 * https://github.com/infoconv/infoconv-ws
	 * 
	 * @param response
	 * @throws AcessoNegadoException
	 * @throws DadosInvalidosException
	 * @throws InfraException
	 * @throws CNPJNaoEncontradoException 
	 */
	private void verificarErros(final Object retorno)
			throws AcessoNegadoException, DadosInvalidosException, InfraException, CNPJNaoEncontradoException {
		try {
			Class<?> c = retorno.getClass();
			Field erroField = c.getDeclaredField("erro");
			erroField.setAccessible(true);
			String erroMsg = (String) erroField.get(retorno);
			if (erroMsg.indexOf("ACS - Erro") > -1) {
				throw new AcessoNegadoException(erroMsg);
			} else if (erroMsg.indexOf("CPJ - Erro 04") > -1) {
				throw new CNPJNaoEncontradoException(erroMsg);
			} else if (erroMsg.indexOf("CPJ - Erro 02") > -1 
					|| erroMsg.indexOf("CPJ - Erro 06") > -1
					|| erroMsg.indexOf("CPJ - Erro 11") > -1) {
				throw new DadosInvalidosException(erroMsg);
			} else if (erroMsg.indexOf("CPJ - Erro 01") > -1 
					|| erroMsg.indexOf("CPJ - Erro 03") > -1
					|| erroMsg.indexOf("CPJ - Erro 00") > -1
					|| erroMsg.indexOf("CPJ - Erro 08") > -1
					|| erroMsg.indexOf("CPJ - Erro 09") > -1) {
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

	/**
	 * Baseado no perfil indicado monta uma lista generia com o tipo de CNPJ do
	 * perfil como Object.
	 * 
	 * @param listaCNPJs
	 * @param perfil
	 * @return
	 * @throws PerfilInvalidoException
	 * @throws InfraException
	 * @throws DadosInvalidosException
	 * @throws AcessoNegadoException
	 * @throws CNPJNaoEncontradoException 
	 */
	public List<Object> consultarListaDeCnpjPorPerfil(final String listaCNPJs, final String perfil)
			throws PerfilInvalidoException, AcessoNegadoException, DadosInvalidosException,
			InfraException, CNPJNaoEncontradoException {
		List<Object> lista = new ArrayList<Object>();
		String perfilUpper = perfil.toUpperCase();
		if (perfil == null || "P1".equals(perfilUpper)) {
			ArrayOfCNPJPerfil1 p = infoconv.consultarCNPJSoap.consultarCNPJP1(listaCNPJs, CPF_CONSULTANTE);
			lista.addAll(p.getCNPJPerfil1());
		} else if ("P1T".equals(perfilUpper)) {
			ArrayOfCNPJPerfil1 p = infoconv.consultarCNPJSoap.consultarCNPJP1T(listaCNPJs, CPF_CONSULTANTE);
			lista.addAll(p.getCNPJPerfil1());
		} else if ("P2".equals(perfilUpper)) {
			ArrayOfCNPJPerfil2 p = infoconv.consultarCNPJSoap.consultarCNPJP2(listaCNPJs, CPF_CONSULTANTE);
			lista.addAll(p.getCNPJPerfil2());
		} else if ("P2T".equals(perfilUpper)) {
			ArrayOfCNPJPerfil2 p = infoconv.consultarCNPJSoap.consultarCNPJP2T(listaCNPJs, CPF_CONSULTANTE);
			lista.addAll(p.getCNPJPerfil2());
		} else if ("P3".equals(perfilUpper)) {
			ArrayOfCNPJPerfil3 p = infoconv.consultarCNPJSoap.consultarCNPJP3(listaCNPJs, CPF_CONSULTANTE);
			lista.addAll(p.getCNPJPerfil3());
		} else if ("P3T".equals(perfilUpper)) {
			ArrayOfCNPJPerfil3 p = infoconv.consultarCNPJSoap.consultarCNPJP3T(listaCNPJs, CPF_CONSULTANTE);
			lista.addAll(p.getCNPJPerfil3());
		} else {
			throw new PerfilInvalidoException();
		}

		verificarErros(lista.get(0));

		return lista;
	}

	/**
	 * Consulta o webservice do infoconv ConsultarCNPJSoap/ConsultarCNPJP1 
	 * 
	 * @param listaCNPJs
	 * @return
	 * @throws AcessoNegadoException
	 * @throws CpfNaoEncontradoException
	 * @throws DadosInvalidosException
	 * @throws InfraException
	 */
	public List<Perfil1CNPJ> listarPerfil1(String listaCNPJs) throws AcessoNegadoException, CNPJNaoEncontradoException, DadosInvalidosException, InfraException{
		ArrayOfCNPJPerfil1 result = infoconv.consultarCNPJSoap.consultarCNPJP1(listaCNPJs, CPF_CONSULTANTE);
		verificarErros(result.getCNPJPerfil1().get(0));
		List<Perfil1CNPJ> lista = new ArrayList<Perfil1CNPJ>();
		for (CNPJPerfil1 perfil1 : result.getCNPJPerfil1()) {
			lista.add(new Perfil1CNPJ(perfil1));
		}		
		return lista;
	}
	
	/**
	 * Consulta o webservice do infoconv ConsultarCNPJSoap/ConsultarCNPJP2 
	 * 
	 * @param listaCNPJs
	 * @return
	 * @throws AcessoNegadoException
	 * @throws CpfNaoEncontradoException
	 * @throws DadosInvalidosException
	 * @throws InfraException
	 */
	public List<Perfil2CNPJ> listarPerfil2(String listaCNPJs) throws AcessoNegadoException, CNPJNaoEncontradoException, DadosInvalidosException, InfraException{
		ArrayOfCNPJPerfil2 result = infoconv.consultarCNPJSoap.consultarCNPJP2(listaCNPJs, CPF_CONSULTANTE);
		verificarErros(result.getCNPJPerfil2().get(0));
		List<Perfil2CNPJ> lista = new ArrayList<Perfil2CNPJ>();
		for (CNPJPerfil2 perfil1 : result.getCNPJPerfil2()) {
			lista.add(new Perfil2CNPJ(perfil1));
		}		
		return lista;
	}
	
	/**
	 * Consulta o webservice do infoconv ConsultarCNPJSoap/ConsultarCNPJP3 
	 * 
	 * @param listaCNPJs
	 * @return
	 * @throws AcessoNegadoException
	 * @throws CpfNaoEncontradoException
	 * @throws DadosInvalidosException
	 * @throws InfraException
	 */
	public List<Perfil3CNPJ> listarPerfil3(String listaCNPJs) throws AcessoNegadoException, CNPJNaoEncontradoException, DadosInvalidosException, InfraException{
		ArrayOfCNPJPerfil3 result = infoconv.consultarCNPJSoap.consultarCNPJP3(listaCNPJs, CPF_CONSULTANTE);
		verificarErros(result.getCNPJPerfil3().get(0));
		List<Perfil3CNPJ> lista = new ArrayList<Perfil3CNPJ>();
		for (CNPJPerfil3 perfil1 : result.getCNPJPerfil3()) {
			lista.add(new Perfil3CNPJ(perfil1));
		}		
		return lista;
	}

}
