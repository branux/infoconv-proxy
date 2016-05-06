package br.gov.serpro.infoconv.proxy.rest.dto.cpf;

import br.gov.serpro.infoconv.ws.cpf.PessoaPerfil1;
import io.swagger.annotations.ApiModelProperty;


public class Perfil1 {
	
	public Perfil1() {
	}

	@ApiModelProperty(value = "Número de inscrição no Cadastro de Pessoas Físicas.", example = "12345678932")
	protected String cpf;

	@ApiModelProperty(value = "Nome da Pessoa Fisica", example = "Fulano da Silva")
	protected String nome;

	@ApiModelProperty(value = "Indicativo da Situação Cadastral do CPF" + "<ul><li>0 = Regular"
			+ "<li>1 = Cancelada por Encerramento de Espólio" + "<li>2 = Suspensa"
			+ "<li>3 = Cancelada por Óbito sem Espolio" + "<li>4 = Pendente de Regularização"
			+ "<li>5 = Cancelada por Multiplicidade" + "<li>8 = Nula" + "<li>9 = Cancelada de Ofício</ul>", example = "0")
	protected String situacaoCadastral;

	@ApiModelProperty(value = "Indicativo de Residente no Exterior." + "<ul><li>1 = Residente"
			+ "<li>2 = Não Residente</ul>", example = "2")
	protected String residenteExterior;
	@ApiModelProperty(value = "Nome da Mãe da Pessoa Física" + "<br>Pode haver registro com o Nome da Mãe em Branco;"
			+ "<br>Pode haver registro com a constante  'MAE DESCONHECIDA'", example = "Maria da Silva")
	protected String nomeMae;

	@ApiModelProperty(value = "Data de inscrição do CPF ou da última operação de atualização", example = "21/01/2000")
	protected String dataAtualizacao;

	@ApiModelProperty(value = "Campo preenchido quando houver problema na recuperação dos dados. <br>Contém uma mensagem descrevendo o erro ocorrido. <a href='https://github.com/infoconv/infoconv-ws' target='_blank'>Lista de erros</a> ", example = "ACS - Erro 15 - Acesso negado. Contrato fora do período de vigência.")
	protected String erro;

	public Perfil1(PessoaPerfil1 pf) {
		this.cpf = pf.getCPF();
		this.nome = pf.getNome();
		this.situacaoCadastral = pf.getSituacaoCadastral();
		this.residenteExterior = pf.getResidenteExterior();
		this.nomeMae = pf.getNomeMae();
		this.dataAtualizacao = pf.getDataAtualizacao();
		this.erro = pf.getErro();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSituacaoCadastral() {
		return situacaoCadastral;
	}

	public void setSituacaoCadastral(String situacaoCadastral) {
		this.situacaoCadastral = situacaoCadastral;
	}

	public String getResidenteExterior() {
		return residenteExterior;
	}

	public void setResidenteExterior(String residenteExterior) {
		this.residenteExterior = residenteExterior;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(String dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

}
