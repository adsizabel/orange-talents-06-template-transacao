package br.com.zup.ot6.izabel.transacao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.ot6.izabel.transacao.entidades.Estabelecimento;

public class EstabelecimentoResponse {
	
	@JsonProperty("nome")
	private String nome;
	@JsonProperty("cidade")
	private String cidade;
	@JsonProperty("endereco")
	private String endereco;
	
	@Deprecated
	public EstabelecimentoResponse() {}
	
	public EstabelecimentoResponse(Estabelecimento estabelecimento) {
		super();
		this.nome = estabelecimento.getNome();
		this.cidade = estabelecimento.getCidade();
		this.endereco = estabelecimento.getEndereco();
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
