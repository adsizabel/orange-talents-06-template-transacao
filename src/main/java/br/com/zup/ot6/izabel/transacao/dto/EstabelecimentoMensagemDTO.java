package br.com.zup.ot6.izabel.transacao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.ot6.izabel.transacao.entidades.Estabelecimento;

public class EstabelecimentoMensagemDTO {

	@JsonProperty("nome")
	private String nome;
	@JsonProperty("cidade")
	private String cidade;
	@JsonProperty("endereco")
	private String endereco;
	
	@Deprecated
	public EstabelecimentoMensagemDTO() {}
	
	public EstabelecimentoMensagemDTO(String nome, String cidade, String endereco) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}
	
	public Estabelecimento converterParaEntidade() {
		return new Estabelecimento(nome, cidade, endereco);
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}
	
	
}
