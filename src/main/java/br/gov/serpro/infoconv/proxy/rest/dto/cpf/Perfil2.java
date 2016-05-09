package br.gov.serpro.infoconv.proxy.rest.dto.cpf;

import br.gov.serpro.infoconv.ws.cpf.PessoaPerfil2;
import io.swagger.annotations.ApiModelProperty;


public class Perfil2 extends Perfil1 {

	@ApiModelProperty(value = "Data de Nascimento da Pessoa Fisica"
			+ "<br> * Pode haver registro com data de nascimento fora do calendário civil.", example = "21/01/2000")
	protected String dataNascimento;
    

	@ApiModelProperty(value = "Indicativo de Sexo da Pessoa Física"
			+ "<ul><li>1 = Masculino;"
			+ "<li>2 = Feminino;"
			+ "<li>9 = Sem informação.</ul>", example = "1")
    protected String sexo;
    
	@ApiModelProperty(value = "Número do título de eleitor.", example = "1234567890987")
    protected String tituloEleitor;
    
	@ApiModelProperty(value = "Ano do óbito no formato AAAA.", example = "2013")
    protected String anoObito;
	
	public Perfil2() {
	}
	
	public Perfil2(PessoaPerfil2 pf) {
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
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}

	public String getAnoObito() {
		return anoObito;
	}

	public void setAnoObito(String anoObito) {
		this.anoObito = anoObito;
	}

	
	

}
