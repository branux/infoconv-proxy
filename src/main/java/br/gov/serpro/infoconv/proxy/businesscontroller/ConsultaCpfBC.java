package br.gov.serpro.infoconv.proxy.businesscontroller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
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

/**
 * Classe responsável por interagir com o componente infoconv-ws para obter
 * as consultas de cpf e transformar os erros previstos em exceções.
 *
 */
@BusinessController
public class ConsultaCpfBC {

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
	 * - CpfNaoEncontradoException: Quando o cpf não está na base.
	 * 		Erros: CPF 04
	 * 
	 * - DadosInvalidosException: Qualquer problema de validação no servidor.
	 * 		Erros: CPF 02,06 e 08
	 * 
	 * - InfraException: Erros no lado do servidor (WS)
	 * 		Erros: CPF 00 e 01
	 * 
	 * Documentação dos códigos de Erros:
	 * https://github.com/infoconv/infoconv-ws
	 * 
	 * @param response
	 * @throws AcessoNegadoException
	 * @throws CpfNaoEncontradoException
	 * @throws DadosInvalidosException
	 * @throws InfraException
	 */
	private void verificarErros(final Object retorno)
			throws AcessoNegadoException, CpfNaoEncontradoException, DadosInvalidosException, InfraException {
		try {
			Class<?> c = retorno.getClass();
			Field erroField = c.getDeclaredField("erro");
			erroField.setAccessible(true);
			String erroMsg = (String) erroField.get(retorno);
			if (erroMsg.indexOf("ACS - Erro") > -1) {
				throw new AcessoNegadoException(erroMsg);
			} else if (erroMsg.indexOf("CPF - Erro 04") > -1) {
				throw new CpfNaoEncontradoException(erroMsg);
			} else if (erroMsg.indexOf("CPF - Erro 02") > -1 || erroMsg.indexOf("CPF - Erro 06") > -1
					|| erroMsg.indexOf("CPF - Erro 08") > -1) {
				throw new DadosInvalidosException(erroMsg);
			} else if (erroMsg.indexOf("CPF - Erro 01") > -1 || erroMsg.indexOf("CPF - Erro 03") > -1
					|| erroMsg.indexOf("CPF - Erro 00") > -1) {
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
	 * Baseado no perfil indicado monta uma lista generia com o tipo de cpf do
	 * perfil como Object.
	 * 
	 * @param listaCPFs
	 * @param perfil
	 * @return
	 * @throws PerfilInvalidoException
	 * @throws InfraException 
	 * @throws DadosInvalidosException 
	 * @throws CpfNaoEncontradoException 
	 * @throws AcessoNegadoException 
	 */
	public List<Object> consultarListaDeCpfPorPerfil(final String listaCPFs, final String perfil)
			throws PerfilInvalidoException, AcessoNegadoException, CpfNaoEncontradoException, DadosInvalidosException, InfraException {
		List<Object> lista = new ArrayList<Object>();
		String perfilUpper = perfil.toUpperCase();
		if (perfil == null || "P1".equals(perfilUpper)) {
			ArrayOfPessoaPerfil1 aPerfil1 = infoconv.consultarCPFSoap.consultarCPFP1(listaCPFs, CPF_CONSULTANTE);
			lista.addAll(aPerfil1.getPessoaPerfil1());
		} else if ("P1A".equals(perfilUpper)) {
			ArrayOfPessoaPerfil1A aPerfil1A = infoconv.consultarCPFSoap.consultarCPFP1A(listaCPFs, CPF_CONSULTANTE);
			lista.addAll(aPerfil1A.getPessoaPerfil1A());
		} else if ("P2".equals(perfilUpper)) {
			ArrayOfPessoaPerfil2 aPerfil2 = infoconv.consultarCPFSoap.consultarCPFP2(listaCPFs, CPF_CONSULTANTE);
			lista.addAll(aPerfil2.getPessoaPerfil2());
		} else if ("P2A".equals(perfilUpper)) {
			ArrayOfPessoaPerfil2A aPerfil2A = infoconv.consultarCPFSoap.consultarCPFP2A(listaCPFs, CPF_CONSULTANTE);
			lista.addAll(aPerfil2A.getPessoaPerfil2A());
		} else if ("P3".equals(perfilUpper)) {
			ArrayOfPessoaPerfil3 aPerfil3 = infoconv.consultarCPFSoap.consultarCPFP3(listaCPFs, CPF_CONSULTANTE);
			lista.addAll(aPerfil3.getPessoaPerfil3());
		} else if ("P3A".equals(perfilUpper)) {
			ArrayOfPessoaPerfil3A aPerfil3A = infoconv.consultarCPFSoap.consultarCPFP3A(listaCPFs, CPF_CONSULTANTE);
			lista.addAll(aPerfil3A.getPessoaPerfil3A());
		} else if ("PD".equals(perfilUpper)) {
			ArrayOfPessoaPerfilD aPerfilD = infoconv.consultarCPFSoap.consultarCPFPD(listaCPFs, CPF_CONSULTANTE);
			lista.addAll(aPerfilD.getPessoaPerfilD());
		} else if ("PD2".equals(perfilUpper)) {
			ArrayOfPessoaPerfilD2 aPerfilD2 = infoconv.consultarCPFSoap.consultarCPFPD2(listaCPFs, CPF_CONSULTANTE);
			lista.addAll(aPerfilD2.getPessoaPerfilD2());
		} else {
			throw new PerfilInvalidoException();
		}
		
		verificarErros(lista.get(0));
		
		return lista;
	}
	
}
