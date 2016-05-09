package br.gov.serpro.infoconv.proxy.rest.dto.cpf;

import br.gov.serpro.infoconv.ws.cpf.PessoaPerfil3;
import io.swagger.annotations.ApiModelProperty;


public class Perfil3 extends Perfil2 {

	@ApiModelProperty(value = "Indicativo de Residente no Exterior<ul>."
			+ "<li>1 = Residente"
			+ "<li>2 = Não Residente </ul>", example = "1")   
    protected String residenteExterior;

	@ApiModelProperty(value = "Caso seja residente no exterior, o código do país onde reside. <a href='http://www.bcb.gov.br/Rex/ftp/paises.asp'> Lista do banco central</a>", example = "1")
	protected String codigoPaisExterior;

	@ApiModelProperty(value = "Caso seja residente no exterior, o nome do país onde reside.", example = "França")
	protected String nomePaisExterior;

	@ApiModelProperty(value = "Código da Natureza da Ocupação da Pessoa Física. ", example = "1")
	protected String naturezaOcupacao;

	@ApiModelProperty(value = "Código da Ocupação Principal da Pessoa Fisica.", example = "1")
	protected String ocupacaoPrincipal;

	@ApiModelProperty(value = "Ano Exercício a que se referem os códigos natureza da ocupação e código da ocupação principal, no formato AAAA", example = "2012")
	protected String exercicioOcupacao;

	@ApiModelProperty(value = "É o nome do tipo do logradouro do domicílio do CPF consultado.", example = "CASA")
	protected String tipoLogradouro;

	@ApiModelProperty(value = "O logradouro do domicílio do CPF consultado.", example = "Rua sem saída")
	protected String logradouro;

	@ApiModelProperty(value = "O número no logradouro do domicílio do CPF consultado.", example = "171")
	protected String numeroLogradouro;

	@ApiModelProperty(value = "O complemento do logradouro do domicílio do CPF consultado.", example = "Apto 123")
	protected String complemento;

	@ApiModelProperty(value = "O CEP do domicílio do CPF consultado.", example = "41760123")
	protected String cep;

	@ApiModelProperty(value = "O bairro do domicílio do CPF consultado.", example = "Cajazeiras 9")
	protected String bairro;

	@ApiModelProperty(value = "O código do município do estabelecimento consultado. <a href='https://www.tomweb.receita.fazenda.gov.br'>Sistema TOM Web</a>", example = "38490")
	protected String codigoMunicipio;

	@ApiModelProperty(value = "O nome do município do domicílio do CPF consultado, conforme <a href='http://www.receita.fazenda.gov.br/publico/tom/TOM.txt'>tabela TOM Municípios</a>.", example = "Salvador")
	protected String municipio;

	@ApiModelProperty(value = "A sigla da Unidade da Federação (Estado) do domicílio do CPF consultado.", example = "BA")
	protected String uf;

	@ApiModelProperty(value = "Número do DDD", example = "71")
	protected String ddd;

	@ApiModelProperty(value = "Número do Telefone", example = "21020202")
	protected String telefone;

	@ApiModelProperty(value = "Código da Unidade Administrativa", example = "0510100")
	protected String unidadeAdministrativa;

	@ApiModelProperty(value = "Indicativo de estrangeiro.<ul>"
			+ "<li>0 = Não é estrangeiro;"
			+ "<li>1 = É estrangeiro</ul>", example = "1")
	protected String estrangeiro;

    
	public Perfil3() {
	}
	
	public Perfil3(PessoaPerfil3 pf) {
		this.cpf = pf.getCPF();
		this.nome = pf.getNome();
		this.situacaoCadastral = pf.getSituacaoCadastral();
		this.residenteExterior = pf.getResidenteExterior();
		this.nomeMae = pf.getNomeMae();
		this.dataAtualizacao = pf.getDataAtualizacao();
		this.erro = pf.getErro();
		this.dataNascimento = pf.getDataNascimento();
		this.sexo = pf.getSexo();
		this.tituloEleitor = pf.getTituloEleitor();
		this.anoObito = pf.getAnoObito();
		
		this.residenteExterior = pf.getResidenteExterior();
		this.codigoPaisExterior = pf.getCodigoPaisExterior();
		this.nomePaisExterior = pf.getNomePaisExterior();
		this.naturezaOcupacao = pf.getNaturezaOcupacao();
		this.ocupacaoPrincipal = pf.getOcupacaoPrincipal();
		this.exercicioOcupacao = pf.getExercicioOcupacao();
		this.tipoLogradouro =  pf.getTipoLogradouro();
		this.logradouro = pf.getLogradouro();
		this.numeroLogradouro = pf.getNumeroLogradouro();
		this.complemento = pf.getComplemento();
		this.cep = pf.getCEP();
		this.bairro = pf.getBairro();
		this.codigoMunicipio = pf.getCodigoMunicipio();
		this.municipio = pf.getMunicipio();
		this.uf = pf.getUF();
		this.ddd = pf.getDDD();
		this.telefone = pf.getTelefone();
		this.unidadeAdministrativa = pf.getUnidadeAdministrativa();
		this.estrangeiro = pf.getEstrangeiro();
		
	}

	public String getResidenteExterior() {
		return residenteExterior;
	}

	public void setResidenteExterior(String residenteExterior) {
		this.residenteExterior = residenteExterior;
	}

	public String getCodigoPaisExterior() {
		return codigoPaisExterior;
	}

	public void setCodigoPaisExterior(String codigoPaisExterior) {
		this.codigoPaisExterior = codigoPaisExterior;
	}

	public String getNomePaisExterior() {
		return nomePaisExterior;
	}

	public void setNomePaisExterior(String nomePaisExterior) {
		this.nomePaisExterior = nomePaisExterior;
	}

	public String getNaturezaOcupacao() {
		return naturezaOcupacao;
	}

	public void setNaturezaOcupacao(String naturezaOcupacao) {
		this.naturezaOcupacao = naturezaOcupacao;
	}

	public String getOcupacaoPrincipal() {
		return ocupacaoPrincipal;
	}

	public void setOcupacaoPrincipal(String ocupacaoPrincipal) {
		this.ocupacaoPrincipal = ocupacaoPrincipal;
	}

	public String getExercicioOcupacao() {
		return exercicioOcupacao;
	}

	public void setExercicioOcupacao(String exercicioOcupacao) {
		this.exercicioOcupacao = exercicioOcupacao;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUnidadeAdministrativa() {
		return unidadeAdministrativa;
	}

	public void setUnidadeAdministrativa(String unidadeAdministrativa) {
		this.unidadeAdministrativa = unidadeAdministrativa;
	}

	public String getEstrangeiro() {
		return estrangeiro;
	}

	public void setEstrangeiro(String estrangeiro) {
		this.estrangeiro = estrangeiro;
	}

	
	
	

}
