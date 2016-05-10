package br.gov.serpro.infoconv.proxy.rest.dto.cnpj;

import br.gov.serpro.infoconv.ws.cnpj.ArrayOfString;
import br.gov.serpro.infoconv.ws.cnpj.CNPJPerfil2;
import io.swagger.annotations.ApiModelProperty;

public class Perfil2CNPJ extends Perfil1CNPJ {

	public Perfil2CNPJ() {
	}

	@ApiModelProperty(
			value = "Data de registro/alteração da situação cadastral.", 
			example = "12122012")
    protected String dataSituacaoCadastral;

	@ApiModelProperty(
			value = "O código da natureza jurídica do estabelecimento consultado. <a href='http://www.receita.fazenda.gov.br/pessoajuridica/cnpj/tabelas/natjurqualificaresponsavel.htm'>Lista de códigos</a>", 
			example = "2011 (Empresa Pública)")
    protected String naturezaJuridica;

	@ApiModelProperty(
			value = "A data de abertura do estabelecimento consultado no formato AAAAMMDD.", 
			example = "20141221")
    protected String dataAbertura;

	@ApiModelProperty(
			value = "A CNAE preferencial do estabelecimento consultado.", 
			example = "0230600")
    protected String cnaePrincipal;

	@ApiModelProperty(
			value = "A CNAE Fiscal Secundária, até 10 ocorrências, do estabelecimento consultado.", 
			example = "12122012")
    protected ArrayOfString cnaeSecundario;

	@ApiModelProperty(
			value = "É o nome do tipo do logradouro do estabelecimento consultado.", 
			example = "Edificio")
    protected String tipoLogradouro;

	@ApiModelProperty(
			value = "O logradouro do estabelecimento consultado.", 
			example = "Rua sem saída")
    protected String logradouro;

	@ApiModelProperty(
			value = "O número no logradouro do estabelecimento consultado.", 
			example = "171")
    protected String numeroLogradouro;

	@ApiModelProperty(
			value = "O complemento do logradouro do estabelecimento consultado.", 
			example = "apt 3209")
    protected String complemento;

	@ApiModelProperty(
			value = "O bairro do estabelecimento consultado.", 
			example = "Costa Azul")
    protected String bairro;
	
	@ApiModelProperty(
			value = "O CEP do estabelecimento consultado.", 
			example = "41760035")
    protected String cep;

	@ApiModelProperty(
			value = "A sigla da Unidade da Federação (Estado) do estabelecimento consultado.", 
			example = "BA")
    protected String uf;

	@ApiModelProperty(
			value = "O código do município do estabelecimento consultado.", 
			example = "123")
    protected String codigoMunicipio;

	@ApiModelProperty(
			value = "O nome do município do estabelecimento consultado, conforme tabela TOM Municípios.", 
			example = "Salvador")
    protected String nomeMunicipio;

	@ApiModelProperty(
			value = "O DDD do primeiro telefone do estabelecimento consultado.", 
			example = "71")
    protected String ddd1;

	@ApiModelProperty(
			value = "O primeiro telefone do estabelecimento consultado.", 
			example = "20027950")
    protected String telefone1;

	@ApiModelProperty(
			value = "O DDD do segundo telefone do estabelecimento consultado.", 
			example = "85")
    protected String ddd2;

	@ApiModelProperty(
			value = "O segundo telefone do estabelecimento consultado.", 
			example = "20027950")
    protected String telefone2;

	@ApiModelProperty(
			value = "O correio eletrônico do estabelecimento consultado.", 
			example = "12122012")
    protected String email;

	public Perfil2CNPJ(CNPJPerfil2 pf) {
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
	}


	public String getDataSituacaoCadastral() {
		return dataSituacaoCadastral;
	}


	public void setDataSituacaoCadastral(String dataSituacaoCadastral) {
		this.dataSituacaoCadastral = dataSituacaoCadastral;
	}


	public String getNaturezaJuridica() {
		return naturezaJuridica;
	}


	public void setNaturezaJuridica(String naturezaJuridica) {
		this.naturezaJuridica = naturezaJuridica;
	}


	public String getDataAbertura() {
		return dataAbertura;
	}


	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}


	public String getCnaePrincipal() {
		return cnaePrincipal;
	}


	public void setCnaePrincipal(String cnaePrincipal) {
		this.cnaePrincipal = cnaePrincipal;
	}


	public ArrayOfString getCnaeSecundario() {
		return cnaeSecundario;
	}


	public void setCnaeSecundario(ArrayOfString cnaeSecundario) {
		this.cnaeSecundario = cnaeSecundario;
	}


	public String getTipoLogradouro() {
		return tipoLogradouro;
	}


	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public String getNumeroLogradouro() {
		return numeroLogradouro;
	}


	public void setNumeroLogradouro(String numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public String getCodigoMunicipio() {
		return codigoMunicipio;
	}


	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}


	public String getNomeMunicipio() {
		return nomeMunicipio;
	}


	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}


	public String getDdd1() {
		return ddd1;
	}


	public void setDdd1(String ddd1) {
		this.ddd1 = ddd1;
	}


	public String getTelefone1() {
		return telefone1;
	}


	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}


	public String getDdd2() {
		return ddd2;
	}


	public void setDdd2(String ddd2) {
		this.ddd2 = ddd2;
	}


	public String getTelefone2() {
		return telefone2;
	}


	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

}
