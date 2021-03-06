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
import br.gov.serpro.infoconv.proxy.rest.dto.cpf.Perfil1;
import br.gov.serpro.infoconv.proxy.rest.dto.cpf.Perfil2;
import br.gov.serpro.infoconv.proxy.rest.dto.cpf.Perfil3;
import br.gov.serpro.infoconv.proxy.rest.dto.cpf.PerfilD;
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
import br.gov.serpro.infoconv.ws.cpf.PessoaPerfil1A;
import br.gov.serpro.infoconv.ws.cpf.PessoaPerfil2;
import br.gov.serpro.infoconv.ws.cpf.PessoaPerfil2A;
import br.gov.serpro.infoconv.ws.cpf.PessoaPerfil3;
import br.gov.serpro.infoconv.ws.cpf.PessoaPerfil3A;
import br.gov.serpro.infoconv.ws.cpf.PessoaPerfilD;
import br.gov.serpro.infoconv.ws.cpf.PessoaPerfilD2;

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
	 * Consulta o webservice do infoconv ConsultarCPFSoap/ConsultarCPFP1 
	 * 
	 * @param listaCPFs
	 * @return
	 * @throws AcessoNegadoException
	 * @throws CpfNaoEncontradoException
	 * @throws DadosInvalidosException
	 * @throws InfraException
	 */
	public List<Perfil1> listarPerfil1(String listaCPFs) throws AcessoNegadoException, CpfNaoEncontradoException, DadosInvalidosException, InfraException{
		ArrayOfPessoaPerfil1 result = infoconv.consultarCPFSoap.consultarCPFP1(listaCPFs, CPF_CONSULTANTE);
		verificarErros(result.getPessoaPerfil1());
		
		List<Perfil1> lista = new ArrayList<Perfil1>();
		for (PessoaPerfil1 perfil1 : result.getPessoaPerfil1()) {
			lista.add(new Perfil1(perfil1));
		}		
		return lista;
	}
	
	/**
	 * Consulta o webservice do infoconv ConsultarCPFSoap/ConsultarCPFP1A 
	 *  
	 * @param listaCPFs
	 * @return
	 * @throws AcessoNegadoException
	 * @throws CpfNaoEncontradoException
	 * @throws DadosInvalidosException
	 * @throws InfraException
	 */
	public List<PessoaPerfil1A> listarPerfil1A(String listaCPFs) throws AcessoNegadoException, CpfNaoEncontradoException, DadosInvalidosException, InfraException{
		ArrayOfPessoaPerfil1A result = infoconv.consultarCPFSoap.consultarCPFP1A(listaCPFs, CPF_CONSULTANTE);
		verificarErros(result.getPessoaPerfil1A());
		return result.getPessoaPerfil1A();
	}
	
	/**
	 * Consulta o webservice do infoconv ConsultarCPFSoap/ConsultarCPFP2 
	 * 
	 * @param listaCPFs
	 * @return
	 * @throws AcessoNegadoException
	 * @throws CpfNaoEncontradoException
	 * @throws DadosInvalidosException
	 * @throws InfraException
	 */
	public List<Perfil2> listarPerfil2(String listaCPFs) throws AcessoNegadoException, CpfNaoEncontradoException, DadosInvalidosException, InfraException{
		ArrayOfPessoaPerfil2 result = infoconv.consultarCPFSoap.consultarCPFP2(listaCPFs, CPF_CONSULTANTE);
		verificarErros(result.getPessoaPerfil2());
		
		List<Perfil2> lista = new ArrayList<Perfil2>();
		for (PessoaPerfil2 p : result.getPessoaPerfil2()) {
			lista.add(new Perfil2(p));
		}
		
		return lista;
	}
	
	/**
	 * Consulta o webservice do infoconv ConsultarCPFSoap/ConsultarCPFP2A 
	 * 
	 * @param listaCPFs
	 * @return
	 * @throws AcessoNegadoException
	 * @throws CpfNaoEncontradoException
	 * @throws DadosInvalidosException
	 * @throws InfraException
	 */
	public List<PessoaPerfil2A> listarPerfil2A(String listaCPFs) throws AcessoNegadoException, CpfNaoEncontradoException, DadosInvalidosException, InfraException{
		ArrayOfPessoaPerfil2A result = infoconv.consultarCPFSoap.consultarCPFP2A(listaCPFs, CPF_CONSULTANTE);
		verificarErros(result.getPessoaPerfil2A());
		return result.getPessoaPerfil2A();
	}
	
	/**
	 * Consulta o webservice do infoconv ConsultarCPFSoap/ConsultarCPFP3
	 * 
	 * @param listaCPFs
	 * @return
	 * @throws AcessoNegadoException
	 * @throws CpfNaoEncontradoException
	 * @throws DadosInvalidosException
	 * @throws InfraException
	 */
	public List<Perfil3> listarPerfil3(String listaCPFs) throws AcessoNegadoException, CpfNaoEncontradoException, DadosInvalidosException, InfraException{
		ArrayOfPessoaPerfil3 result = infoconv.consultarCPFSoap.consultarCPFP3(listaCPFs, CPF_CONSULTANTE);
		verificarErros(result.getPessoaPerfil3());
		List<Perfil3> lista = new ArrayList<Perfil3>();
		for (PessoaPerfil3 p : result.getPessoaPerfil3()) {
			lista.add(new Perfil3(p));
		}
		
		return lista;
	}
	
	/**
	 * Consulta o webservice do infoconv ConsultarCPFSoap/ConsultarCPFP3A
	 * 
	 * @param listaCPFs
	 * @return
	 * @throws AcessoNegadoException
	 * @throws CpfNaoEncontradoException
	 * @throws DadosInvalidosException
	 * @throws InfraException
	 */
	public List<PessoaPerfil3A> listarPerfil3A(String listaCPFs) throws AcessoNegadoException, CpfNaoEncontradoException, DadosInvalidosException, InfraException{
		ArrayOfPessoaPerfil3A result = infoconv.consultarCPFSoap.consultarCPFP3A(listaCPFs, CPF_CONSULTANTE);
		verificarErros(result.getPessoaPerfil3A());
		return result.getPessoaPerfil3A();
	}
	
	/**
	 * Consulta o webservice do infoconv ConsultarCPFSoap/ConsultarCPFPD 
	 * 
	 * @param listaCPFs
	 * @return
	 * @throws AcessoNegadoException
	 * @throws CpfNaoEncontradoException
	 * @throws DadosInvalidosException
	 * @throws InfraException
	 */
	public List<PerfilD> listarPerfilD(String listaCPFs) throws AcessoNegadoException, CpfNaoEncontradoException, DadosInvalidosException, InfraException{
		ArrayOfPessoaPerfilD result = infoconv.consultarCPFSoap.consultarCPFPD(listaCPFs, CPF_CONSULTANTE);
		verificarErros(result.getPessoaPerfilD());
		List<PerfilD> lista = new ArrayList<PerfilD>();
		for (PessoaPerfilD p : result.getPessoaPerfilD()) {
			lista.add(new PerfilD(p));
		}
		
		return lista;
	}
	
	/**
	 * Consulta o webservice do infoconv ConsultarCPFSoap/ConsultarCPFPD2 
	 * 
	 * @param listaCPFs
	 * @return
	 * @throws AcessoNegadoException
	 * @throws CpfNaoEncontradoException
	 * @throws DadosInvalidosException
	 * @throws InfraException
	 */
	public List<PessoaPerfilD2> listarPerfilD2(String listaCPFs) throws AcessoNegadoException, CpfNaoEncontradoException, DadosInvalidosException, InfraException{
		ArrayOfPessoaPerfilD2 result = infoconv.consultarCPFSoap.consultarCPFPD2(listaCPFs, CPF_CONSULTANTE);
		verificarErros(result.getPessoaPerfilD2());
		return result.getPessoaPerfilD2();
	}
	
	
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
	private void verificarErros(final List<?> retorno)
			throws AcessoNegadoException, CpfNaoEncontradoException, DadosInvalidosException, InfraException {
		
		/* Se retorna muitos elementos não podemos lançar exceção */
		if(retorno.size()>0) return;
		
		try {
			Object primeiro = retorno.get(0);			
			Class<?> c = primeiro.getClass();
			Field erroField = c.getDeclaredField("erro");
			erroField.setAccessible(true);
			String erroMsg = (String) erroField.get(primeiro);
			if (erroMsg.indexOf("ACS - Erro") > -1) {
				throw new AcessoNegadoException(erroMsg);
			} else if (retorno.size()==1 && erroMsg.indexOf("CPF - Erro 04") > -1) {
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
		
		verificarErros(lista);
		
		return lista;
	}



	
}
