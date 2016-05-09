package br.gov.serpro.infoconv.proxy.rest.dto.cpf;

import br.gov.serpro.infoconv.ws.cpf.PessoaPerfilD;


public class PerfilD extends Perfil3 {

    
	public PerfilD() {
	}
	
	public PerfilD(PessoaPerfilD pf) {
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

}
