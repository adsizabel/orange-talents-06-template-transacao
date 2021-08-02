package br.com.zup.ot6.izabel.transacao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.ot6.izabel.transacao.entidades.Cartao;

public class CartaoMensagemDTO {
	@JsonProperty("id")
	private String id;
	@JsonProperty("email")
	private String email;
	
	@Deprecated
	public CartaoMensagemDTO() {}
	
	public CartaoMensagemDTO(String id, String email) {
		super();
		this.id = id;
		this.email = email;
	}
	
	public Cartao converterParaEntidade() {
		return new Cartao(id, email);
	}
	
	public String getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	
	
}
