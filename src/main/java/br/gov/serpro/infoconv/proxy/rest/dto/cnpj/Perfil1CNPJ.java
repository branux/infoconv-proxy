package br.gov.serpro.infoconv.proxy.rest.dto.cnpj;

import br.gov.serpro.infoconv.ws.cnpj.CNPJPerfil1;
import io.swagger.annotations.ApiModelProperty;

public class Perfil1CNPJ {

	public Perfil1CNPJ() {
	}

	@ApiModelProperty(value = "Número de inscrição no Cadastro CNPJ a ser informado.", 
			example = "1234567893212")
	protected String cnpj;

	@ApiModelProperty(value = "Indicador de matriz/filial. <br>"
			+ "<ul>Sendo:"
			+ "<li> 1 – MATRIZ "
			+ "<li> 2 – FILIAL.</ul>", 
			example = "1")
	protected String estabelecimento;
	
	@ApiModelProperty(value = "O nome empresarial do estabelecimento consultado.", 
			example = "Servico Federal de Processamento de Dados (Serpro)")
	protected String nomeEmpresarial;
	
	@ApiModelProperty(value = "O nome fantasia da empresa consultada.", 
			example = "Serpro")
	protected String nomeFantasia;
	
	@ApiModelProperty(value = "A situação cadastral da empresa consultada."
			+ "<br>Sendo:  <ul><li>01 – NULA,"
			+ "<li>02 – ATIVA,"
			+ "<li>03 – SUSPENSA,"
			+ "<li>04 – INAPTA,"
			+ "<li>08 – BAIXADA. </ul>", 
			example = "02")
	protected String situacaoCadastral;
	
	@ApiModelProperty(value = "A cidade do Exterior, caso o estabelecimento consultado for domiciliado no exterior.", 
			example = "Cansas")
	protected String cidadeExterior;
	
	@ApiModelProperty(value = "Código do País, caso o estabelecimento consultado for domiciliado no exterior.", 
			example = "055")
	protected String codigoPais;
	
	@ApiModelProperty(value = "Nome do país, caso o estabelecimento consultado for domiciliado no exterior.", 
			example = "Estados Unidos")
	protected String nomePais;
	
	@ApiModelProperty(value = "Campo preenchido quando houver problema na recuperação dos dados. <br>Contém uma mensagem descrevendo o erro ocorrido. <a href='https://github.com/infoconv/infoconv-ws' target='_blank'>Lista de erros</a> ", example = "ACS - Erro 15 - Acesso negado. Contrato fora do período de vigência.")
	protected String erro;

	public Perfil1CNPJ(CNPJPerfil1 pf) {
		this.cnpj = pf.getCNPJ();
		this.estabelecimento = pf.getEstabelecimento();
		this.nomeEmpresarial = pf.getNomeEmpresarial();
		this.nomeFantasia = pf.getNomeFantasia();
		this.situacaoCadastral = pf.getSituacaoCadastral();
		this.cidadeExterior = pf.getCidadeExterior();
		this.codigoPais = pf.getCodigoPais();
		this.nomePais = pf.getNomePais();
		this.erro = pf.getErro();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public String getNomeEmpresarial() {
		return nomeEmpresarial;
	}

	public void setNomeEmpresarial(String nomeEmpresarial) {
		this.nomeEmpresarial = nomeEmpresarial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getSituacaoCadastral() {
		return situacaoCadastral;
	}

	public void setSituacaoCadastral(String situacaoCadastral) {
		this.situacaoCadastral = situacaoCadastral;
	}

	public String getCidadeExterior() {
		return cidadeExterior;
	}

	public void setCidadeExterior(String cidadeExterior) {
		this.cidadeExterior = cidadeExterior;
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getNomePais() {
		return nomePais;
	}

	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

}
