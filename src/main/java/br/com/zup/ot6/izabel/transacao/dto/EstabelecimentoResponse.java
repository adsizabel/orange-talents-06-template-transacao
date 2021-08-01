package br.com.zup.ot6.izabel.transacao.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EstabelecimentoResponse {

	@JsonProperty("nome")
	private String nome;
	@JsonProperty("cidade")
	private String cidade;
	@JsonProperty("endereco")
	private String endereco;
	
	@Deprecated
	public EstabelecimentoResponse() {}
	
	public EstabelecimentoResponse(String nome, String cidade, String endereco) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
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
