package br.gov.serpro.infoconv.proxy.rest.dto.cnpj;

import br.gov.serpro.infoconv.ws.cnpj.ArrayOfSocio;
import br.gov.serpro.infoconv.ws.cnpj.ArrayOfString;
import br.gov.serpro.infoconv.ws.cnpj.CNPJPerfil3;
import io.swagger.annotations.ApiModelProperty;

public class Perfil3CNPJ extends Perfil2CNPJ {

	public Perfil3CNPJ() {
	}

	@ApiModelProperty(
			value = "O número do CPF do responsável pelo estabelecimento consultado.", 
			example = "82596374122")	
    protected String cpfResponsavel;
	
	@ApiModelProperty(
			value = "O nome do responsável pelo estabelecimento consultado.", 
			example = "Fulano da Silva")
    protected String nomeResponsavel;
    
	@ApiModelProperty(
			value = "Valor do Capital Social da empresa consultada", 
			example = "1000000")
    protected String capitalSocial;
    
	@ApiModelProperty(
			value = "Quadro Societário(Sociedade) - Composto por até 300 ocorrências do tipo <Socio><br>"
					+ "Socio:<ul>"
					+ "<li>Tipo -  1(SÓCIO PJ),2(SÓCIO PF) e 3(SÓCIO ESTRANGEIRO)"
					+ "<li>Nome - Nome do sócio do estabelecimento consultado."
					+ "<li>Numero - Número do CNPJ ou CPF do sócio do estabelecimento consultado, sendo que, se sócio estrangeiro este campo será 99999999999999."
					+ "Para saber se o campo é um CNPJ, ou CPF, consultar o campo \"Tipo\" (Se 1 = CNPJ, se 2 = CPF). Se for um número de CPF, ignorar os três primeiros dígitos e pegar apenas os 11 últimos."
					+ "<li>Percentual Participacao - Percentual de participação do sócio no capital social da empresa"
					+ "<li>CodigoPaisOrigem - Código do país de origem do sócio estrangeiro"
					+ "<li>NomePaisOrigem - Nome do país de origem do sócio estrangeiro</ul>")
    protected ArrayOfSocio sociedade;

	@ApiModelProperty(
			value = "Código do tipo do CRC do contador PJ."
					+ "<ul><li>O = Originário"
					+ "<li>T = Transferido"
					+ "<li>S = Secundário"
					+ "<li>P = Provisório"
					+ "<li>F = Filiais</ul>", 
			example = "O")
    protected String tipoCRCContadorPJ;

	@ApiModelProperty(
			value = "Código da classificação do CRC do contador PJ."
					+ "<ul><li>1 = Profissional"
					+ "<li>2 = Escritório Sociedade"
					+ "<li>3 = Escritório Individual</ul>", 
			example = "1")
    protected String classificacaoCRCContadorPJ;

	@ApiModelProperty(
			value = "Número do CRC do contador PJ.", 
			example = "000000")
    protected String numeroCRCContadorPJ;

	@ApiModelProperty(
			value = "Sigla da Unidade da Federação (Estado) do CRC do contador PJ.", 
			example = "BA")
    protected String ufcrcContadorPJ;

	@ApiModelProperty(
			value = "Número do CNPJ do contador do estabelecimento consultado.", 
			example = "00000000000000")
    protected String cnpjContador;

	@ApiModelProperty(
			value = "Código do tipo do CRC do contador PF."
					+ "<ul><li>O = Originário"
					+ "<li>T = Transferido"
					+ "<li>S = Secundário"
					+ "<li>P = Provisório"
					+ "<li>F = Filiais</ul>", 
			example = "O")
    protected String tipoCRCContadorPF;

	@ApiModelProperty(
			value = "Código da classificação do CRC do contador PF."
					+ "<ul><li>1 = Profissional"
					+ "<li>2 = Escritório Sociedade"
					+ "<li>3 = Escritório Individual</ul>", 
			example = "1")
    protected String classificacaoCRCContadorPF;

	@ApiModelProperty(
			value = "Número do CRC do contador PF.", 
			example = "000000")
    protected String numeroCRCContadorPF;

	@ApiModelProperty(
			value = "Sigla da Unidade da Federação (Estado) do CRC do contador PF.", 
			example = "BA")
    protected String ufcrcContadorPF;

	@ApiModelProperty(
			value = "Número do CPF do contador do estabelecimento consultado.", 
			example = "82596374122")
    protected String cpfContador;

	@ApiModelProperty(
			value = "O porte do estabelecimento consultado.<ul>"
					+ "<li>01 – MICROEMPRESA,"
					+ "<li>03 -  EMPRESA DE PEQUENO PORTE"
					+ "<li>05 -  DEMAIS.</ul>", 
			example = "01")
    protected String porte;

	@ApiModelProperty(
			value = "Indicador de opção pelo simples, “S” ou “N”.", 
			example = "S")
    protected String opcaoSimples;

	@ApiModelProperty(
			value = "Data em que a empresa fez sua opção pelo Simples, no formato AAAAMMDD.", 
			example = "20150317")
    protected String dataOpcaoSimples;

	@ApiModelProperty(
			value = "Data em que a empresa foi excluída do Simples no formato AAAAMMDD.", 
			example = "20150317")
    protected String dataExclusaoSimples;

	@ApiModelProperty(
			value = "Número do CNPJ da Sucedida. Este campo será sempre preenchido com o CNPJ consultado.", 
			example = "00000000000000")
    protected String cnpjSucedida;

	@ApiModelProperty(
			value = "Número dos CNPJ’s das Sucessoras caso haja uma Operação de Sucessão."
					+ "Ocorre até 8 vezes  ", 
			example = "[00000000000000,00000000000000]")
    protected ArrayOfString cnpjSucessora;

	public Perfil3CNPJ(CNPJPerfil3 pf) {
		this.cnpj = pf.getCNPJ();
		this.estabelecimento = pf.getEstabelecimento();
		this.nomeEmpresarial = pf.getNomeEmpresarial();
		this.nomeFantasia = pf.getNomeFantasia();
		this.situacaoCadastral = pf.getSituacaoCadastral();
		this.cidadeExterior = pf.getCidadeExterior();
		this.codigoPais = pf.getCodigoPais();
		this.nomePais = pf.getNomePais();
		this.erro = pf.getErro();
		
		this.dataSituacaoCadastral = pf.getDataSituacaoCadastral();   
	    this.naturezaJuridica = pf.getNaturezaJuridica();
	    this.dataAbertura = pf.getDataAbertura();
	    this.cnaePrincipal = pf.getCNAEPrincipal();
	    this.cnaeSecundario = pf.getCNAESecundario();
	    this.tipoLogradouro = pf.getTipoLogradouro();
	    this.logradouro = pf.getLogradouro();
	    this.numeroLogradouro = pf.getNumeroLogradouro();
	    this.complemento = pf.getComplemento();
	    this.bairro = pf.getBairro();
	    this.cep = pf.getCEP();
	    this.uf = pf.getUF();
	    this.codigoMunicipio = pf.getCodigoMunicipio();
	    this.nomeMunicipio = pf.getNomeMunicipio();
	    this.ddd1 = pf.getDDD1();
	    this.telefone1 = pf.getTelefone1();
	    this.ddd2 = pf.getDDD2();
	    this.telefone2 = pf.getTelefone2();
	    this.email = pf.getEmail();
	    
	    this.cpfResponsavel = pf.getCPFResponsavel();		
	    this.nomeResponsavel = pf.getNomeResponsavel();	    	
	    this.capitalSocial = pf.getCapitalSocial();  
	    this.sociedade = pf.getSociedade();
	    this.tipoCRCContadorPJ = pf.getTipoCRCContadorPJ();
	    this.classificacaoCRCContadorPJ = pf.getClassificacaoCRCContadorPJ();
	    this.numeroCRCContadorPJ = pf.getNumeroCRCContadorPJ();
	    this.ufcrcContadorPJ = pf.getUFCRCContadorPJ();
	    this.cnpjContador = pf.getCNPJContador();
	    this.tipoCRCContadorPF = pf.getTipoCRCContadorPF();
	    this.classificacaoCRCContadorPF = pf.getClassificacaoCRCContadorPF();
	    this.numeroCRCContadorPF = pf.getNumeroCRCContadorPF();
	    this.ufcrcContadorPF = pf.getUFCRCContadorPF();
	    this.cpfContador = pf.getCPFContador();
	    this.porte = pf.getPorte();
	    this.opcaoSimples = pf.getOpcaoSimples();
	    this.dataOpcaoSimples = pf.getDataOpcaoSimples();
	    this.dataExclusaoSimples = pf.getDataExclusaoSimples();
	    this.cnpjSucedida = pf.getCNPJSucedida();
	    this.cnpjSucessora = pf.getCNPJSucessora(); 
	}

	public String getCpfResponsavel() {
		return cpfResponsavel;
	}

	public void setCpfResponsavel(String cpfResponsavel) {
		this.cpfResponsavel = cpfResponsavel;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getCapitalSocial() {
		return capitalSocial;
	}

	public void setCapitalSocial(String capitalSocial) {
		this.capitalSocial = capitalSocial;
	}

	public ArrayOfSocio getSociedade() {
		return sociedade;
	}

	public void setSociedade(ArrayOfSocio sociedade) {
		this.sociedade = sociedade;
	}

	public String getTipoCRCContadorPJ() {
		return tipoCRCContadorPJ;
	}

	public void setTipoCRCContadorPJ(String tipoCRCContadorPJ) {
		this.tipoCRCContadorPJ = tipoCRCContadorPJ;
	}

	public String getClassificacaoCRCContadorPJ() {
		return classificacaoCRCContadorPJ;
	}

	public void setClassificacaoCRCContadorPJ(String classificacaoCRCContadorPJ) {
		this.classificacaoCRCContadorPJ = classificacaoCRCContadorPJ;
	}

	public String getNumeroCRCContadorPJ() {
		return numeroCRCContadorPJ;
	}

	public void setNumeroCRCContadorPJ(String numeroCRCContadorPJ) {
		this.numeroCRCContadorPJ = numeroCRCContadorPJ;
	}

	public String getUfcrcContadorPJ() {
		return ufcrcContadorPJ;
	}

	public void setUfcrcContadorPJ(String ufcrcContadorPJ) {
		this.ufcrcContadorPJ = ufcrcContadorPJ;
	}

	public String getCnpjContador() {
		return cnpjContador;
	}

	public void setCnpjContador(String cnpjContador) {
		this.cnpjContador = cnpjContador;
	}

	public String getTipoCRCContadorPF() {
		return tipoCRCContadorPF;
	}

	public void setTipoCRCContadorPF(String tipoCRCContadorPF) {
		this.tipoCRCContadorPF = tipoCRCContadorPF;
	}

	public String getClassificacaoCRCContadorPF() {
		return classificacaoCRCContadorPF;
	}

	public void setClassificacaoCRCContadorPF(String classificacaoCRCContadorPF) {
		this.classificacaoCRCContadorPF = classificacaoCRCContadorPF;
	}

	public String getNumeroCRCContadorPF() {
		return numeroCRCContadorPF;
	}

	public void setNumeroCRCContadorPF(String numeroCRCContadorPF) {
		this.numeroCRCContadorPF = numeroCRCContadorPF;
	}

	public String getUfcrcContadorPF() {
		return ufcrcContadorPF;
	}

	public void setUfcrcContadorPF(String ufcrcContadorPF) {
		this.ufcrcContadorPF = ufcrcContadorPF;
	}

	public String getCpfContador() {
		return cpfContador;
	}

	public void setCpfContador(String cpfContador) {
		this.cpfContador = cpfContador;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getOpcaoSimples() {
		return opcaoSimples;
	}

	public void setOpcaoSimples(String opcaoSimples) {
		this.opcaoSimples = opcaoSimples;
	}

	public String getDataOpcaoSimples() {
		return dataOpcaoSimples;
	}

	public void setDataOpcaoSimples(String dataOpcaoSimples) {
		this.dataOpcaoSimples = dataOpcaoSimples;
	}

	public String getDataExclusaoSimples() {
		return dataExclusaoSimples;
	}

	public void setDataExclusaoSimples(String dataExclusaoSimples) {
		this.dataExclusaoSimples = dataExclusaoSimples;
	}

	public String getCnpjSucedida() {
		return cnpjSucedida;
	}

	public void setCnpjSucedida(String cnpjSucedida) {
		this.cnpjSucedida = cnpjSucedida;
	}

	public ArrayOfString getCnpjSucessora() {
		return cnpjSucessora;
	}

	public void setCnpjSucessora(ArrayOfString cnpjSucessora) {
		this.cnpjSucessora = cnpjSucessora;
	}
	
	


	
}
